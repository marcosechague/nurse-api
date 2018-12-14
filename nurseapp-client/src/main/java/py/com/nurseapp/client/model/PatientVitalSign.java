/*
 * Nurse App api documentation
 * Nurse app api with all services provided.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: marcos.echague@gmail.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package py.com.nurseapp.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.OffsetDateTime;
import py.com.nurseapp.client.model.Patient;
import py.com.nurseapp.client.model.VitalSign;

/**
 * PatientVitalSign
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-12-11T23:44:44.553-03:00")
public class PatientVitalSign {
  @SerializedName("condition")
  private String condition = null;

  @SerializedName("id")
  private Integer id = null;

  @SerializedName("patient")
  private Patient patient = null;

  @SerializedName("registerDate")
  private OffsetDateTime registerDate = null;

  /**
   * Gets or Sets status
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    ACTIVE("ACTIVE"),
    
    INAVTIVE("INAVTIVE");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("status")
  private StatusEnum status = null;

  @SerializedName("valueVitalSign")
  private Integer valueVitalSign = null;

  @SerializedName("vitalSign")
  private VitalSign vitalSign = null;

  public PatientVitalSign condition(String condition) {
    this.condition = condition;
    return this;
  }

   /**
   * Get condition
   * @return condition
  **/
  @ApiModelProperty(value = "")
  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  public PatientVitalSign id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public PatientVitalSign patient(Patient patient) {
    this.patient = patient;
    return this;
  }

   /**
   * Get patient
   * @return patient
  **/
  @ApiModelProperty(value = "")
  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public PatientVitalSign registerDate(OffsetDateTime registerDate) {
    this.registerDate = registerDate;
    return this;
  }

   /**
   * Get registerDate
   * @return registerDate
  **/
  @ApiModelProperty(value = "")
  public OffsetDateTime getRegisterDate() {
    return registerDate;
  }

  public void setRegisterDate(OffsetDateTime registerDate) {
    this.registerDate = registerDate;
  }

  public PatientVitalSign status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public PatientVitalSign valueVitalSign(Integer valueVitalSign) {
    this.valueVitalSign = valueVitalSign;
    return this;
  }

   /**
   * Get valueVitalSign
   * @return valueVitalSign
  **/
  @ApiModelProperty(value = "")
  public Integer getValueVitalSign() {
    return valueVitalSign;
  }

  public void setValueVitalSign(Integer valueVitalSign) {
    this.valueVitalSign = valueVitalSign;
  }

  public PatientVitalSign vitalSign(VitalSign vitalSign) {
    this.vitalSign = vitalSign;
    return this;
  }

   /**
   * Get vitalSign
   * @return vitalSign
  **/
  @ApiModelProperty(value = "")
  public VitalSign getVitalSign() {
    return vitalSign;
  }

  public void setVitalSign(VitalSign vitalSign) {
    this.vitalSign = vitalSign;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatientVitalSign patientVitalSign = (PatientVitalSign) o;
    return Objects.equals(this.condition, patientVitalSign.condition) &&
        Objects.equals(this.id, patientVitalSign.id) &&
        Objects.equals(this.patient, patientVitalSign.patient) &&
        Objects.equals(this.registerDate, patientVitalSign.registerDate) &&
        Objects.equals(this.status, patientVitalSign.status) &&
        Objects.equals(this.valueVitalSign, patientVitalSign.valueVitalSign) &&
        Objects.equals(this.vitalSign, patientVitalSign.vitalSign);
  }

  @Override
  public int hashCode() {
    return Objects.hash(condition, id, patient, registerDate, status, valueVitalSign, vitalSign);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatientVitalSign {\n");
    
    sb.append("    condition: ").append(toIndentedString(condition)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    patient: ").append(toIndentedString(patient)).append("\n");
    sb.append("    registerDate: ").append(toIndentedString(registerDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    valueVitalSign: ").append(toIndentedString(valueVitalSign)).append("\n");
    sb.append("    vitalSign: ").append(toIndentedString(vitalSign)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
