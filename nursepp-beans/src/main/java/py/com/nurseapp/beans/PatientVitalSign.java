package py.com.nurseapp.beans;

import java.util.Date;

public class PatientVitalSign {

    private Integer id;
    private Patient patient;
    private VitalSign vitalSign;
    private Integer valueVitalSign;
    private Date registerDate;
    private String condition;
    private Status status;
    

    PatientVitalSign(Integer id, Patient patient, VitalSign vitalSign, Integer valueVitalSign, Date registerDate, Status status, String condition) {
        this.patient = patient;
        this.vitalSign = vitalSign;
        this.valueVitalSign = valueVitalSign;
        this.registerDate = registerDate;
        this.condition = condition;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public VitalSign getVitalSign() {
        return vitalSign;
    }

    public Integer getValueVitalSign() {
        return valueVitalSign;
    }

    public String getCondition() {
        return condition;
    }
    
    public Date getRegisterDate() {
		return registerDate;
	}
    public Status getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "PatientVitalSign [id=" + id + ", patient=" + patient + ", vitalSign=" + vitalSign + ", valueVitalSign="
				+ valueVitalSign + ", registerDate=" + registerDate + ", condition=" + condition + ", status=" + status
				+ "]";
	}

}
