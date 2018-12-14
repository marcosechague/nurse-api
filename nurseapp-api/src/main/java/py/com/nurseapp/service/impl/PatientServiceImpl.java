package py.com.nurseapp.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.nurseapp.beans.Patient;
import py.com.nurseapp.beans.PatientVitalSign;
import py.com.nurseapp.beans.PatientVitalSignBuilder;
import py.com.nurseapp.beans.Status;
import py.com.nurseapp.beans.VitalSign;
import py.com.nurseapp.dao.PatientDao;
import py.com.nurseapp.dao.VitalSignDao;
import py.com.nurseapp.dto.request.PatientDto;
import py.com.nurseapp.dto.request.PatientVitalSignDto;
import py.com.nurseapp.dto.response.ResponsePatientVitalSignDto;
import py.com.nurseapp.dto.response.ResponsePatientVitalSignListDto;
import py.com.nurseapp.exception.EmptyDataNurseAppException;
import py.com.nurseapp.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;
    @Autowired
    private VitalSignDao vitalSignDao;

    @Override
    public Patient createPatient(PatientDto patientDto) {
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date bDate;
		try {
			bDate = formatter.parse(patientDto.getBithDate());
		} catch (ParseException e) {
			throw new RuntimeException();
		}
    	
       Patient patientCreated = patientDao.createPatient(patientDto.getName(), patientDto.getDocument(), new java.sql.Date (bDate.getTime()));
        return patientCreated;
    }

    @Override
    public void deletePatient(Integer codPatient) {
            patientDao.deletePatient(codPatient);
    }

    @Override
    public void updatePatient(PatientDto patientDto) {

    }

    @Override
    public Patient getPatient(Integer idPatient) {
    	return patientDao.getPatient(idPatient).orElseThrow(() -> new EmptyDataNurseAppException("pa1000", "No Patient found"));
    }

    @Override
    public List<Patient> getPatients(String name, String document, Status status) {
        return patientDao.getPatients(name, document, status).orElseThrow(() -> new EmptyDataNurseAppException("pa1000", "No Patient found"));
    }

    @Override
    public ResponsePatientVitalSignDto registerPatientVitalSign(PatientVitalSignDto patientVitalSignDto) {

        Patient patient = patientDao.getPatient(patientVitalSignDto.getIdPatient()).orElseThrow(() -> new EmptyDataNurseAppException("pa1000", "No patient found"));
        Integer valueVitalSign = patientVitalSignDto.getValueVitalSign();
        List<VitalSign> vitalSignsByCode = getVitalSignByCode(patientVitalSignDto.getCodVitalSign());
        Integer patientAge = getYears(patient.getBirthDate());
        VitalSign vitalSignForPatientAge = vitalSignsByCode.stream().filter (vs -> patientAge>= vs.getMinAge() && patientAge<=vs.getMaxAge()).findFirst().orElseThrow(() -> new EmptyDataNurseAppException("vsp1000", "No vital sign for patient found"));
        String condition = getPatientCondition(patientAge, patientVitalSignDto.getValueVitalSign(), vitalSignForPatientAge);

        Integer idRegistered = patientDao.registerPatientVitalSign(patient.getCodPatient(),vitalSignForPatientAge.getIdVitalSign(),valueVitalSign, condition );

        PatientVitalSignBuilder patientVitalSignBuilder = new PatientVitalSignBuilder();

        ResponsePatientVitalSignDto response = new ResponsePatientVitalSignDto(
                                                patientVitalSignBuilder .idPatientVitalSign(idRegistered)
                                                                        .patient(patient)
                                                                        .vitalSign(vitalSignForPatientAge)
                                                                        .valueVitalSign(valueVitalSign)
                                                                        .condition(condition)
                                                                        .registerDate(new Date())
                                                                        .build());
        return response;
    }
    
    @Override
	public ResponsePatientVitalSignListDto getPatientsVitalSign(String document) {
    	List<PatientVitalSign> patientVitalSigns = patientDao.getPatientHistoryVitalSign(document).orElseThrow(() -> new EmptyDataNurseAppException("pvs1000", "No vital signs for patient found"));
    	ResponsePatientVitalSignListDto response = new ResponsePatientVitalSignListDto();
    	response.setPatientVitalSign(patientVitalSigns);    	
		return response;
	}
    
    
    private List<VitalSign> getVitalSignByCode(String code){
    	List<VitalSign> vitalSignsByCode = vitalSignDao.getVitalSigns(code, null, null, null, null, null,null).orElseThrow(() -> new EmptyDataNurseAppException("vs1000", "No vital sign found")); 
    	return vitalSignsByCode;
    }

    private Integer getYears(Date dateFrom){
    	LocalDate date = null;
    	if(dateFrom instanceof java.sql.Date) {
    		java.sql.Date dateSql = (java.sql.Date) dateFrom;
    		date = dateSql.toLocalDate();
    	}else {
    		date = dateFrom.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    	}
        long years = ChronoUnit.YEARS.between(date, LocalDate.now());
        return (int) years;
    }

    private String getPatientCondition(Integer age, Integer valueVitalSignTaken, VitalSign vitalSign){
        if(valueVitalSignTaken.intValue() < vitalSign.getMinRange() ) return vitalSign.getLowLevelDescription();
        if(valueVitalSignTaken.intValue() > vitalSign.getMaxRange() ) return vitalSign.getHighLevelDescription();
        return vitalSign.getNormalLevelDescription();
    }
}
