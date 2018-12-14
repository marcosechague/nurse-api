package py.com.nurseapp.dto.response;

import java.text.SimpleDateFormat;

import py.com.nurseapp.beans.PatientVitalSign;
import py.com.nurseapp.beans.PatientVitalSignResponse;

public class ResponsePatientVitalSignDto {
    private PatientVitalSignResponse  patientVitalSign;

    public ResponsePatientVitalSignDto() {
    }

    public ResponsePatientVitalSignDto(PatientVitalSign patientVitalSign) {
        this.patientVitalSign = buildResponse(patientVitalSign);
    }

    public PatientVitalSignResponse getPatientVitalSign() {
        return patientVitalSign;
    }

    public void setPatientVitalSign(PatientVitalSign patientVitalSign) {
        this.patientVitalSign = buildResponse(patientVitalSign);
    }
    
    public static PatientVitalSignResponse buildResponse(PatientVitalSign patient) {
    	
    		PatientVitalSignResponse pr = new PatientVitalSignResponse();
    		pr.setCondition(patient.getCondition());
    		pr.setId(patient.getId());
    		pr.setPatient(patient.getPatient());
    		pr.setStatus(patient.getStatus());
    		pr.setValueVitalSign(patient.getValueVitalSign());
    		pr.setVitalSign(patient.getVitalSign());
    		
    		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    		String dateString = formatter.format(patient.getRegisterDate());
    		pr.setRegisterDate(dateString);
    		
    	return pr ;
    }

    @Override
    public String toString() {
        return "ResponsePatientVitalSignDto{" + "patientVitalSign=" + patientVitalSign + '}';
    }
}
