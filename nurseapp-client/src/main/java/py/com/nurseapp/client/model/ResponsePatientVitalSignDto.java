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
import py.com.nurseapp.client.model.PatientVitalSignResponse;

/**
 * ResponsePatientVitalSignDto
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-12-13T05:51:56.690-03:00")
public class ResponsePatientVitalSignDto {
  @SerializedName("patientVitalSign")
  private PatientVitalSignResponse patientVitalSign = null;

  public ResponsePatientVitalSignDto patientVitalSign(PatientVitalSignResponse patientVitalSign) {
    this.patientVitalSign = patientVitalSign;
    return this;
  }

   /**
   * Get patientVitalSign
   * @return patientVitalSign
  **/
  @ApiModelProperty(value = "")
  public PatientVitalSignResponse getPatientVitalSign() {
    return patientVitalSign;
  }

  public void setPatientVitalSign(PatientVitalSignResponse patientVitalSign) {
    this.patientVitalSign = patientVitalSign;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponsePatientVitalSignDto responsePatientVitalSignDto = (ResponsePatientVitalSignDto) o;
    return Objects.equals(this.patientVitalSign, responsePatientVitalSignDto.patientVitalSign);
  }

  @Override
  public int hashCode() {
    return Objects.hash(patientVitalSign);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponsePatientVitalSignDto {\n");
    
    sb.append("    patientVitalSign: ").append(toIndentedString(patientVitalSign)).append("\n");
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

