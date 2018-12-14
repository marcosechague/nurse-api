package py.com.nurseapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.nurseapp.beans.Status;
import py.com.nurseapp.beans.VitalSign;
import py.com.nurseapp.dao.VitalSignDao;
import py.com.nurseapp.exception.EmptyDataNurseAppException;
import py.com.nurseapp.service.VitalSignService;

@Service
public class VitalSignServiceImpl implements VitalSignService {

    @Autowired
    private VitalSignDao vitalSignDao;

	@Override
	public VitalSign getVitalSign(Integer idVitalSign) {
		return vitalSignDao.getVitalSign(idVitalSign).orElseThrow(() -> new EmptyDataNurseAppException("vs1000", "No vital sign found"));
	}

	@Override
	public List<VitalSign> getVitalSigns(String code, Integer minAge, Integer maxAge, Integer minValue,Integer maxValue, String description, Status status) {
		List<VitalSign> vitalSigns=vitalSignDao.getVitalSigns(code, description, minAge, maxAge, minValue, maxValue,status).orElseThrow(() -> new EmptyDataNurseAppException("vs1000", "No vital sign found"));
		if(vitalSigns.size()==0) throw  new EmptyDataNurseAppException("vs1000", "No vital sign found");
		return  vitalSigns;
	}
}
