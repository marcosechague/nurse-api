package py.com.nurseapp.service;

import java.util.List;

import py.com.nurseapp.beans.Status;
import py.com.nurseapp.beans.VitalSign;

public interface VitalSignService {
    public VitalSign getVitalSign(Integer idVitalSign);
    public List<VitalSign> getVitalSigns(String code,Integer minAge, Integer maxAge, Integer minValue, Integer maxValue, String description, Status status) ;

}
