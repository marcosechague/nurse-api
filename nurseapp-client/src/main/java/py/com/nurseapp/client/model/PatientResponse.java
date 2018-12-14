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

/**
 * PatientResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-12-13T05:51:56.690-03:00")
public class PatientResponse {
  @SerializedName("birthDate")
  private String birthDate = null;

  @SerializedName("codPatient")
  private Integer codPatient = null;

  @SerializedName("document")
  private String document = null;

  @SerializedName("name")
  private String name = null;

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

  public PatientResponse birthDate(String birthDate) {
    this.birthDate = birthDate;
    return this;
  }

   /**
   * Get birthDate
   * @return birthDate
  **/
  @ApiModelProperty(value = "")
  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public PatientResponse codPatient(Integer codPatient) {
    this.codPatient = codPatient;
    return this;
  }

   /**
   * Get codPatient
   * @return codPatient
  **/
  @ApiModelProperty(value = "")
  public Integer getCodPatient() {
    return codPatient;
  }

  public void setCodPatient(Integer codPatient) {
    this.codPatient = codPatient;
  }

  public PatientResponse document(String document) {
    this.document = document;
    return this;
  }

   /**
   * Get document
   * @return document
  **/
  @ApiModelProperty(value = "")
  public String getDocument() {
    return document;
  }

  public void setDocument(String document) {
    this.document = document;
  }

  public PatientResponse name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PatientResponse status(StatusEnum status) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatientResponse patientResponse = (PatientResponse) o;
    return Objects.equals(this.birthDate, patientResponse.birthDate) &&
        Objects.equals(this.codPatient, patientResponse.codPatient) &&
        Objects.equals(this.document, patientResponse.document) &&
        Objects.equals(this.name, patientResponse.name) &&
        Objects.equals(this.status, patientResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(birthDate, codPatient, document, name, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatientResponse {\n");
    
    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
    sb.append("    codPatient: ").append(toIndentedString(codPatient)).append("\n");
    sb.append("    document: ").append(toIndentedString(document)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

