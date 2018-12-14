package py.com.nurseapp.beans;

public class PatientVitalSignResponse {

    private Integer id;
    private Patient patient;
    private VitalSign vitalSign;
    private Integer valueVitalSign;
    private String registerDate;
    private String condition;
    private Status status;

    

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Patient getPatient() {
		return patient;
	}



	public void setPatient(Patient patient) {
		this.patient = patient;
	}



	public VitalSign getVitalSign() {
		return vitalSign;
	}



	public void setVitalSign(VitalSign vitalSign) {
		this.vitalSign = vitalSign;
	}



	public Integer getValueVitalSign() {
		return valueVitalSign;
	}



	public void setValueVitalSign(Integer valueVitalSign) {
		this.valueVitalSign = valueVitalSign;
	}



	public String getRegisterDate() {
		return registerDate;
	}



	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}



	public String getCondition() {
		return condition;
	}



	public void setCondition(String condition) {
		this.condition = condition;
	}



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "PatientVitalSign [id=" + id + ", patient=" + patient + ", vitalSign=" + vitalSign + ", valueVitalSign="
				+ valueVitalSign + ", registerDate=" + registerDate + ", condition=" + condition + ", status=" + status
				+ "]";
	}

}
