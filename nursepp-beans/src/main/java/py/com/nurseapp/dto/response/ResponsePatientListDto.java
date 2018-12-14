package py.com.nurseapp.dto.response;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import py.com.nurseapp.beans.Patient;
import py.com.nurseapp.beans.PatientResponse;

public class ResponsePatientListDto {

    private List<PatientResponse> patients;

    public ResponsePatientListDto() {
    }

    public ResponsePatientListDto(List<Patient> patients) {
        this.patients = buildResponse(patients);
    }

    public List<PatientResponse> getPatients() {
        return patients;
    }

    public void setPatients(List<PatientResponse> patients) {
        this.patients = patients;
    }

    private List<PatientResponse> buildResponse(List<Patient> patient) {
    	List<PatientResponse> resp = new ArrayList<>();
    	patient.stream().forEach(p -> {
    		PatientResponse pr = new PatientResponse();
    		pr.setCodPatient(p.getCodPatient());
    		pr.setDocument(p.getDocument());
    		pr.setName(p.getName());
    		pr.setStatus(p.getStatus());
    		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    		String dateString = formatter.format(p.getBirthDate());
    		pr.setBirthDate(dateString);
    		resp.add(pr);
    	});
    	return resp ;
    }
    
    @Override
    public String toString() {
        return "ResponsePatientListDto{" + "patients=" + patients + '}';
    }
}
