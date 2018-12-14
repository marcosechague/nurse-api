package py.com.nurseapp.dto.response;

import java.util.ArrayList;
import java.util.List;

import py.com.nurseapp.beans.PatientVitalSign;
import py.com.nurseapp.beans.PatientVitalSignResponse;

public class ResponsePatientVitalSignListDto {

    private List<PatientVitalSignResponse>  patientVitalSigns;

    public ResponsePatientVitalSignListDto() {
    }

    public ResponsePatientVitalSignListDto(List<PatientVitalSign> patientVitalSigns) {
        this.patientVitalSigns = buildResponse(patientVitalSigns);
    }

    public List<PatientVitalSignResponse> getPatientVitalSigns() {
        return patientVitalSigns;
    }

    public void setPatientVitalSign(List<PatientVitalSign> patientVitalSigns) {
        this.patientVitalSigns = buildResponse(patientVitalSigns);
    }
    
    private List<PatientVitalSignResponse> buildResponse(List<PatientVitalSign> patient) {
    	List<PatientVitalSignResponse> resp = new ArrayList<>();
    	patient.stream().forEach(p -> {
    		PatientVitalSignResponse pr = ResponsePatientVitalSignDto.buildResponse(p);
    		resp.add(pr);
    	});
    	return resp ;
    }

    @Override
    public String toString() {
        return "ResponsePatientVitalSignDto{" + "patientVitalSigns=" + patientVitalSigns + '}';
    }
}
