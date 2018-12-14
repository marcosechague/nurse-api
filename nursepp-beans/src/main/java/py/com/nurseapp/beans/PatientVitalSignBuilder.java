package py.com.nurseapp.beans;

import java.util.Date;

public class PatientVitalSignBuilder {

    private Integer id;
    private Patient patient;
    private VitalSign vitalSign;
    private Integer valueVitalSign;
    private Date registerDate;
    private String condition;
    private Status status;

    public PatientVitalSignBuilder idPatientVitalSign (Integer id){
        this.id = id;
        return this;
    }

    public PatientVitalSignBuilder patient (Patient patient){
        this.patient = patient;
        return this;
    }

    public PatientVitalSignBuilder vitalSign (VitalSign vitalSign){
        this.vitalSign = vitalSign;
        return this;
    }

    public PatientVitalSignBuilder registerDate (Date registerDate){
        this.registerDate = registerDate;
        return this;
    }
    
    public PatientVitalSignBuilder valueVitalSign (Integer valueVitalSign){
        this.valueVitalSign = valueVitalSign;
        return this;
    }

    public PatientVitalSignBuilder condition (String  condition){
        this.condition = condition;
        return this;
    }
    
    public PatientVitalSignBuilder status (Status  status){
        this.status = status;
        return this;
    }
    
    
    public PatientVitalSign build (){
        return new PatientVitalSign(id, patient, vitalSign, valueVitalSign, registerDate, status, condition);
    }

}
