package py.com.nurseapp.dto.request;

import javax.validation.constraints.NotNull;

import py.com.nurseapp.beans.Status;

public class PatientDto {

    @NotNull
    private String name;
    @NotNull
    private String document;
    @NotNull
    private String bithDate;

    private Status status = Status.ACTIVE; //default

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

    public String getBithDate() {
        return bithDate;
    }

    public void setBithDate(String bithDate) {
        this.bithDate = bithDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PatientDto{" + "name='" + name + '\'' + ", document='" + document + '\'' + ", bithDate=" + bithDate + '}';
    }
}
