package py.com.nurseapp.controller;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import py.com.nurseapp.beans.Patient;
import py.com.nurseapp.beans.PatientResponse;
import py.com.nurseapp.beans.Status;
import py.com.nurseapp.dto.request.PatientDto;
import py.com.nurseapp.dto.request.PatientVitalSignDto;
import py.com.nurseapp.dto.response.ResponsePatientListDto;
import py.com.nurseapp.dto.response.ResponsePatientVitalSignDto;
import py.com.nurseapp.dto.response.ResponsePatientVitalSignListDto;
import py.com.nurseapp.service.PatientService;

@RestController
public class PatientController {

    static final String BASE_CONTROLLER_PATH = "patients";

    private static final Logger LOGGER= LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;

    @ApiOperation(value="Register patient", notes="Create new patient", response=Patient.class)
    @PostMapping("patients")
    @ResponseStatus(code=HttpStatus.CREATED)
    public Patient createPatient(HttpServletResponse response,
            @RequestBody
            @Valid PatientDto patientDto ) throws MalformedURLException {
        LOGGER.info("IN POST /patients {}", patientDto);
        Patient patientRegister = patientService.createPatient(patientDto);
        LOGGER.info("OUT POST /patients {} ",patientRegister);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id-patient}")
                .buildAndExpand(patientRegister.getCodPatient()).toUri();
        response.setHeader("Location", location.toString());
        return patientRegister;
    }

    @ApiOperation(value="Get patient", notes="Get patient's data. given an id-patient", response=Patient.class)
    @RequestMapping(value = "patients/{id}", method = RequestMethod.GET)
    @ResponseStatus(code=HttpStatus.OK)
    public PatientResponse getPatient(
            @PathVariable(value="id")Integer idPatient) {
        LOGGER.info("IN GET /patients/{}",idPatient);
        Patient patient = patientService.getPatient(idPatient);
        PatientResponse response = new PatientResponse(patient);
        LOGGER.info("OUT GET /patients/{}  {}",idPatient, patient);
        return  response;
    }

    @ApiOperation(value="Get patients", notes="Get patient a list of patients", response=ResponsePatientListDto.class)
    @GetMapping("patients")
    @ResponseStatus(code=HttpStatus.OK)
    public ResponsePatientListDto getPatients(
            @RequestParam(value="patient-name", required = false) String patientName ,
            @RequestParam(value="document", required = false)String document,
            @RequestParam(value="status", required = false)Status status) {
        LOGGER.info("IN GET /patients/ with params {},{},{}",patientName, document, status);
        List<Patient> patients = patientService.getPatients(patientName, document, status);
        ResponsePatientListDto patiensList = new ResponsePatientListDto(patients);
        LOGGER.info("OUT GET /patients {} ",patiensList);
        return  patiensList;
    }

    @ApiOperation(value="Update patient", notes="Update patient data")
    @PutMapping("patients/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void updatePatient(
            @PathVariable(value="id")Integer idPatient,
            @RequestBody
            @Valid PatientDto patientDto ){
        LOGGER.info("IN PUT /patients {}", patientDto);
        patientService.createPatient(patientDto);
        LOGGER.info("OUT PUT /patients OK");
    }

    @ApiOperation(value="Delete patient", notes="Delete patient data")
    @DeleteMapping("patients/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deletePatient(
            @PathVariable(value="id")Integer idPatient){
        LOGGER.info("IN DELETE /patients/{}", idPatient);
        patientService.deletePatient(idPatient);
        LOGGER.info("OUT DELETE /patients OK");
    }

    @ApiOperation(value="Register history patient vital sign ", notes="Register a new history patient vital sign ", response=ResponsePatientVitalSignDto.class)
    @PostMapping("/patientes/vital-signs")
    public ResponsePatientVitalSignDto createHistoryPatientVitalSign(HttpServletResponse response,
            @RequestBody
            @Valid PatientVitalSignDto patientVitalSignDto ) {
        LOGGER.info("IN POST /patients/vital-signs {}", patientVitalSignDto);
        ResponsePatientVitalSignDto responsePatientListDto = patientService.registerPatientVitalSign(patientVitalSignDto);
        LOGGER.info("OUT POST /patients/vital-signs {} ",responsePatientListDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id-patient}")
                .buildAndExpand(responsePatientListDto.getPatientVitalSign().getId()).toUri();
        response.setHeader("Location", location.toString());
        return responsePatientListDto;
    }
    
    @ApiOperation(value="Get patients vital signs history", notes="Get a list of patient's vital signs registered", response=ResponsePatientVitalSignListDto.class)
    @GetMapping("patients/vital-signs")
    @ResponseStatus(code=HttpStatus.OK)
    public ResponsePatientVitalSignListDto getPatientsVitalSign(
            @RequestParam(value="document", required = true)String document) {
        LOGGER.info("IN GET patients/vital-signs with params {}",document);
        ResponsePatientVitalSignListDto response = patientService.getPatientsVitalSign(document);
        LOGGER.info("OUT GET patients/vital-signs {} ",response);
        return  response;
    }

}
