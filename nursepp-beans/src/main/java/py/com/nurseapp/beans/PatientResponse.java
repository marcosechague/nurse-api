package py.com.nurseapp.beans;

import java.text.SimpleDateFormat;

public class PatientResponse {

    private Integer codPatient;
    private String name;
    private String document;
    private String birthDate;
    private Status status;

    public PatientResponse() {
    }
    
    public PatientResponse(Patient patient) {
    	this.codPatient = patient.getCodPatient();
    	this.name = patient.getName();
    	this.document = patient.getDocument();
    	this.status = patient.getStatus();
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    	String dateString = formatter.format(patient.getBirthDate());
    	this.birthDate = dateString;
    }
    
    public Integer getCodPatient() {
        return codPatient;
    }

    public void setCodPatient(Integer codPatient) {
        this.codPatient = codPatient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Patient{" + "codPatient=" + codPatient + ", name='" + name + '\'' + ", document='" + document + '\'' + ", birthDate='" + birthDate + '\'' + ", status=" + status + '}';
    }
}
