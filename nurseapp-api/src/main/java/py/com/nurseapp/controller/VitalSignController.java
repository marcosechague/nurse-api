package py.com.nurseapp.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import py.com.nurseapp.beans.Status;
import py.com.nurseapp.beans.VitalSign;
import py.com.nurseapp.dto.response.ResponseVitalSignListDto;
import py.com.nurseapp.service.VitalSignService;

@RestController
public class VitalSignController {

    private static final Logger LOGGER= LogManager.getLogger(VitalSignController.class);

    @Autowired
    private VitalSignService vitalSignService;

//    @ApiOperation(value="Register vital sign", notes="Create new vital sign", response=VitalSign.class)
//    @PostMapping("vital-signs")
//    @ResponseStatus(code=HttpStatus.CREATED)
//    public VitalSign createVitalSign(HttpServletResponse response,
//            @RequestBody
//            @Valid VitalSignDto vitalSignDto ) throws MalformedURLException {
//        LOGGER.info("IN POST /vital-signs {}", patientDto);
//        VitalSign vitalSißgnRegister = vitalSignService.createVitalSign(patientDto);
//        LOGGER.info("OUT POST /vital-signs {} ",patientRegister);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest().path("/{id-patient}")
//                .buildAndExpand(patientRegister.getCodVitalSign()).toUri();
//        response.setHeader("Location", location.toString());
//        return patientRegister;
//    }

    

    @ApiOperation(value="Get vital sign", notes="Get vital sign's data. given an cod of vital sign", response=VitalSign.class)
    @RequestMapping(value = "vital-signs/{id}", method = RequestMethod.GET)
    @ResponseStatus(code=HttpStatus.OK)
    public VitalSign getVitalSign(
            @PathVariable(value="id")Integer idVitalSign) {
        LOGGER.info("IN GET /vital-signs/{}",idVitalSign);
        VitalSign vitalSign  = vitalSignService.getVitalSign(idVitalSign);
        LOGGER.info("OUT GET /vital-signs/{}  {}",idVitalSign, vitalSign);
        return  vitalSign;
    }


    @ApiOperation(value="Get vital signs", notes="Get list of vital signs", response=ResponseVitalSignListDto.class)
    @GetMapping("vital-signs")
    @ResponseStatus(code=HttpStatus.OK)
    public ResponseVitalSignListDto getVitalSigns(
            @RequestParam(value="code", required = false)String code,
            @RequestParam(value="max-age", required = false)Integer maxAge,
            @RequestParam(value="min-age", required = false)Integer minAge,
            @RequestParam(value="max-value", required = false)Integer maxValue,
            @RequestParam(value="min-value", required = false)Integer minValue,
            @RequestParam(value="description", required = false)String description,
            @RequestParam(value="status", required = false)Status status) {
        LOGGER.info("IN GET /vital-signs/ with params code{}, minAge{}, maxAge{}, minValue{}, maxValue{}, description{}, status{}",code, minAge, maxAge, minValue, maxValue, description, status);
        List<VitalSign> vitalSigns = vitalSignService.getVitalSigns(code, minAge, maxAge, minValue, maxValue, description, status);
        ResponseVitalSignListDto vitalSignList = new ResponseVitalSignListDto( vitalSigns);
        LOGGER.info("OUT GET /vital-signs {} ",vitalSignList);
        return  vitalSignList;
    }
//
//    @ApiOperation(value="Update vital sign", notes="Update vital sign data")
//    @PutMapping("vital-signs/{id}")
//    @ResponseStatus(code=HttpStatus.NO_CONTENT)
//    public void updateVitalSign(
//            @PathVariable(value="id")Integer idVitalSign,
//            @RequestBody
//            @Valid VitalSignDto çDto ){
//      
//    }
//
//    @ApiOperation(value="Delete vital sign", notes="Delete vital sign data")
//    @DeleteMapping("vital-signs/{id}")
//    @ResponseStatus(code=HttpStatus.NO_CONTENT)
//    public void deleteVitalSign(
//            @PathVariable(value="id")Integer idVitalSign){
//        
//    }

}
