package py.com.nurseapp.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import py.com.nurseapp.beans.Status;
import py.com.nurseapp.beans.VitalSign;
import py.com.nurseapp.dao.VitalSignDao;
import py.com.nurseapp.exception.DatabaseNurseAppException;

@Repository
public class VitalSignDaoImpl extends JdbcDaoSupport implements VitalSignDao {
	private final String SQL_GET_VITAL_SIGN_BY_ID = "SELECT vs.id_vital_sign, description, high_level_description, normal_level_description, low_level_description, status, code, min_age, max_age, max_healty_value, min_healty_value  "
			+ " FROM public.vital_signs vs "
			+ " JOIN vital_signs_data vsd "
			+ " ON vs.id_vital_sign = vsd.id_vital_sign "
			+ " where vs.id_vital_sign = ? ";
    
	private final String SQL_GET_VITAL_SIGN = "SELECT vs.id_vital_sign, description, high_level_description, normal_level_description, low_level_description, status, code, min_age, max_age, max_healty_value, min_healty_value  "
			+ " FROM public.vital_signs vs "
			+ " JOIN vital_signs_data vsd "
			+ " ON vs.id_vital_sign = vsd.id_vital_sign ";
	
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public Optional<VitalSign> getVitalSign(Integer idVitalSign) {
    	try{	
			logger.info("SQL->"+SQL_GET_VITAL_SIGN_BY_ID);
			logger.info("1: "+idVitalSign);
			VitalSign vitalSign = getJdbcTemplate().queryForObject(SQL_GET_VITAL_SIGN_BY_ID, new VitalSignMapper() , idVitalSign);
			
			return Optional.ofNullable(vitalSign);
		} catch (EmptyResultDataAccessException e) {
			logger.warn("No vitsl sign with id "+idVitalSign);
			return Optional.empty();
		} catch (DataAccessException e) {
			logger.error("Database error", e);
			throw new DatabaseNurseAppException("pa1000","Error getting patients",e);
		}
    }

    @Override
    public Optional<List<VitalSign>> getVitalSigns(String code, String description, Integer minAge, Integer maxAge, Integer minValue, Integer maxValue, Status status) {
        
    	try{	
    		String sql = buildVitalSignCallWithConditions(code, description, minAge, maxAge, minValue, maxValue, status);
    		logger.info("SQL -> "+sql);
        	logger.info("code: "+(code==null? "no included": code));
        	logger.info("description: "+(description==null? "no included": description));
        	logger.info("min age: "+(minAge==null? "no included": minAge));
        	logger.info("max age: "+(maxAge==null? "no included": maxAge));
        	logger.info("min value: "+(minAge==null? "no included": minValue));
        	logger.info("max value: "+(maxAge==null? "no included": maxValue));
        	logger.info("status: "+(status==null? "no included": status));

			List<VitalSign> vitalSigns =  getJdbcTemplate().execute(new CallableStatementCreator() {
				@Override
				public CallableStatement createCallableStatement(Connection con)
						throws SQLException {

					CallableStatement cs = con.prepareCall(sql);
					Integer index = 1;
					if(code!=null){
						cs.setString(index, "%"+code+"%");
						index++;
					}
					if(description!=null){
						cs.setString(index, "%"+description+"%");
						index++;
					}
					if(minAge!=null){
						cs.setInt(index, minAge);
						index++;
					}
					if(maxAge!=null){
						cs.setInt(index, maxAge);
						index++;
					}
					if(minValue!=null){
						cs.setInt(index, minValue);
						index++;
					}
					if(maxValue!=null){
						cs.setInt(index, maxValue);
						index++;
					}
					if(status!=null){
						cs.setString(++index, "%"+status.name()+"%");
					}
					return cs;
				}
			}, new CallableStatementCallback<List<VitalSign>>() {
				@Override
				public List<VitalSign> doInCallableStatement(CallableStatement cs)
						throws SQLException, DataAccessException {
					List<VitalSign> vss = new ArrayList<VitalSign>();

					ResultSet rs = cs.executeQuery();
					while (rs.next()) {
						VitalSign vitalSign = getVitalSignFromResultSet(rs);
						vss.add(vitalSign);
					}
					return vss;
				}
			});
			
			return Optional.ofNullable(vitalSigns);
		} catch (EmptyResultDataAccessException e) {
			logger.warn("No patient found with those parameters ");
			return Optional.empty();
		} catch (DataAccessException e) {
			logger.error("Database error", e);
			throw new DatabaseNurseAppException("vs1000","Error getting vital signs",e);
		}

    }
    
    private String buildVitalSignCallWithConditions(String code, String description, Integer minAge, Integer maxAge, Integer minValue, Integer maxValue, Status status) {
    	String nextClause  =  " WHERE ";
    	String sqlResult = SQL_GET_VITAL_SIGN;
    	
    	if(code!=null) {
    		sqlResult+=nextClause+" code LIKE ? ";
    		nextClause = " OR ";
    	}
    	if(description!=null) {
    		sqlResult+=nextClause+" description LIKE ? ";
    		nextClause = " OR ";
    	}
    	if(minAge!=null) {
    		sqlResult+=nextClause+" min_age >= ? ";
    		nextClause = " OR ";
    	}
    	if(maxAge!=null) {
    		sqlResult+=nextClause+" max_age <= ? ";
    		nextClause = " OR ";
    	}
    	if(minValue!=null) {
    		sqlResult+=nextClause+" min_healty_value >= ? ";
    		nextClause = " OR ";
    	}
    	if(maxValue!=null) {
    		sqlResult+=nextClause+" max_healty_value <= ? ";
    		nextClause = " OR ";
    	}
    	
    	if(status!=null) {
    		sqlResult+=nextClause+" status LIKE ? ";
    	}
    	return sqlResult;
    }
    
    private class VitalSignMapper implements RowMapper<VitalSign> {
		@Override
		public VitalSign mapRow(ResultSet rs, int rowNum) throws SQLException {
			return getVitalSignFromResultSet(rs);
		}
	}
	
	private VitalSign getVitalSignFromResultSet(ResultSet rs) throws SQLException{
		
		VitalSign vitalSign = new VitalSign();		
		vitalSign.setIdVitalSign(rs.getInt("id_vital_sign"));
		vitalSign.setDescription(rs.getString("description"));
		vitalSign.setCode(rs.getString("code"));
		vitalSign.setMaxAge(rs.getInt("max_age"));
		vitalSign.setMinAge(rs.getInt("min_age"));
		vitalSign.setMaxRange(rs.getInt("max_healty_value"));
		vitalSign.setMinRange(rs.getInt("min_healty_value"));
		vitalSign.setHighLevelDescription(rs.getString("high_level_description"));
		vitalSign.setLowLevelDescription(rs.getString("low_level_description"));
		vitalSign.setNormalLevelDescription(rs.getString("normal_level_description"));
		vitalSign.setStatus(Status.valueOf( rs.getString("status")));
		
		return vitalSign;
	}
    
}
