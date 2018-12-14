package py.com.nurseapp.dto.response;

import java.util.List;

import py.com.nurseapp.beans.VitalSign;

public class ResponseVitalSignListDto {

    private List<VitalSign> vitalSign;

    public ResponseVitalSignListDto() {
    }

	public ResponseVitalSignListDto(List<VitalSign> vitalSign) {
		super();
		this.vitalSign = vitalSign;
	}

	public List<VitalSign> getVitalSign() {
		return vitalSign;
	}

	public void setVitalSign(List<VitalSign> vitalSign) {
		this.vitalSign = vitalSign;
	}

	@Override
	public String toString() {
		return "ResponseVitalSignListDto [vitalSign=" + vitalSign + "]";
	}

}
