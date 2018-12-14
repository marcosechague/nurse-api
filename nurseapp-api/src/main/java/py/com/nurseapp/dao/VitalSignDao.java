package py.com.nurseapp.dao;

import java.util.List;
import java.util.Optional;

import py.com.nurseapp.beans.Status;
import py.com.nurseapp.beans.VitalSign;

public interface VitalSignDao {
    public Optional<VitalSign> getVitalSign(Integer idVitalSign) ;
	public Optional<List<VitalSign>> getVitalSigns(String code, String description, Integer minAge, Integer maxAge, Integer minValue, Integer maxValue, Status status);
}
