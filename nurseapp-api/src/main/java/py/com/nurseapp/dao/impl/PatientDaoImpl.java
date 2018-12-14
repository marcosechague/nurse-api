package py.com.nurseapp.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import py.com.nurseapp.beans.Patient;
import py.com.nurseapp.beans.PatientVitalSign;
import py.com.nurseapp.beans.PatientVitalSignBuilder;
import py.com.nurseapp.beans.Status;
import py.com.nurseapp.beans.VitalSign;
import py.com.nurseapp.dao.PatientDao;
import py.com.nurseapp.exception.ApplicationNurseAppException;
import py.com.nurseapp.exception.DatabaseNurseAppException;

@Repository
public class PatientDaoImpl  extends JdbcDaoSupport implements PatientDao {

    private static final String SQL_INSERT_PATIENT = "INSERT INTO public.patients (name, document, bithdate) VALUES ( ?, ?, ?)";
    private static final String SQL_GET_PATIENT_BY_ID = "SELECT * FROM public.patients WHERE id_patient = ?";
    private static final String SQL_GET_PATIENTS = "SELECT * FROM public.patients ";
    private static final String SQL_DELETE_PATIENT_BY_ID = "DELETE FROM public.patients WHERE id_patient = ?";
    private static final String SQL_GET_PATIENT_BY_DOCUMENT = "SELECT * FROM public.patients WHERE document = ?";
    private static final String SQL_GET_PATIENT_HISTORY_VITAL_SIGN =  "SELECT id_history, pvs.id_patient, pvs.id_vital_sign, pvs.value_vital_sign, pvs.register_date, pvs.condition_description, pvs.status,  vs.code,vs.description, " + 
															    		"p.name, p.document, p.bithdate, p.status as patient_status " + 
															    		"FROM public.patien_vital_sign_history pvs " + 
															    		"join public.vital_signs vs " + 
															    		"on  pvs.id_vital_sign = vs.id_vital_sign " + 
															    		"join public.patients p " + 
															    		"on pvs.id_patient = p.id_patient " + 
															    		"where p.document = ? " + 
															    		"order by register_date desc";
    
    private static final String SQL_INSERT_PATIENT_VITAL_ISIGN = "INSERT INTO public.patien_vital_sign_history (id_patient, id_vital_sign, value_vital_sign, condition_description) "
    														   + " VALUES(?, ?, ?, ? ) ";


    
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }


    @Override
    public Patient createPatient(String name, String document, java.sql.Date birthDate){

        logger.info(SQL_INSERT_PATIENT);
        logger.info("1:" + name);
        logger.info("2:" + document);
        logger.info("3:" + birthDate);
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            getJdbcTemplate().update(new PreparedStatementCreator() {
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(SQL_INSERT_PATIENT, new String[]{"id_patient"});
                    ps.setString(1, name);
                    ps.setString(2, document);
                    ps.setDate(3, birthDate);
                    return ps;
                }
            }, keyHolder);
            Integer id = (Integer) keyHolder.getKey();
            Patient patientRegistered = getPatient(id).orElseGet(null);
            return patientRegistered;

        } catch (DataIntegrityViolationException e) {
            logger.error("Data integrity error ", e);
             throw new RuntimeException("Documen "+ document+" already exist");
        } catch (DataAccessException e) {
            logger.error("Database error", e);
            throw new DatabaseNurseAppException("Error getting patients",e);
        }
    }

    @Override
    public void deletePatient(Integer codPatient) {
    	logger.info(SQL_DELETE_PATIENT_BY_ID);
        logger.info("1:" + codPatient);
        try { 
        	getJdbcTemplate().update(SQL_DELETE_PATIENT_BY_ID, codPatient);
        } catch (RuntimeException e)  {
        	logger.error("Error while delete the patient", e);
            throw new ApplicationNurseAppException("dp1000", "Error Error while delete the patient ",e);
        }
    }

    @Override
    public Patient updatePatient(String name, String documento, Date birthDate, Status status) {
    	return null;
    }

    @Override
    public Optional<Patient> getPatient(Integer idPatient) {
    	try{	
			logger.info("SQL->"+SQL_GET_PATIENT_BY_ID);
			logger.info("1: "+idPatient);
			Patient patient = getJdbcTemplate().queryForObject(SQL_GET_PATIENT_BY_ID, new PatientMapper() , idPatient);
			
			return Optional.ofNullable(patient);
		} catch (EmptyResultDataAccessException e) {
			logger.warn("No patient with id "+idPatient);
			return Optional.empty();
		} catch (DataAccessException e) {
			logger.error("Database error", e);
			throw new DatabaseNurseAppException("pa1000","Error getting patients",e);
		}
    }
    
    @Override
    public Optional<Patient> getPatient(String document) {
    	try{	
			logger.info("SQL->"+SQL_GET_PATIENT_BY_DOCUMENT);
			logger.info("1: "+document);
			Patient patient = getJdbcTemplate().queryForObject(SQL_GET_PATIENT_BY_DOCUMENT, new PatientMapper() , document);
			
			return Optional.ofNullable(patient);
		} catch (EmptyResultDataAccessException e) {
			logger.warn("No patient with document "+document);
			return Optional.empty();
		} catch (DataAccessException e) {
			logger.error("Database error", e);
			throw new DatabaseNurseAppException("pa1000","Error getting patient",e);
		}
    }

    @Override
    public Optional<List<Patient>> getPatients(String name, String document, Status status) {
        
    	try{	
    		String sql = buildPatientsCallWithConditions(name, document, status);
    		logger.info("SQL -> "+sql);
        	logger.info("name: "+(name==null? "no included": name));
        	logger.info("document: "+(document==null? "no included": document));
        	logger.info("status: "+(status==null? "no included": status));

			List<Patient> patients =  getJdbcTemplate().execute(new CallableStatementCreator() {
				@Override
				public CallableStatement createCallableStatement(Connection con)
						throws SQLException {

					CallableStatement cs = con.prepareCall(sql);
					Integer index = 1;
					if(name!=null){
						cs.setString(index, "%"+name+"%");
						index++;
					}
					if(document!=null){
						cs.setString(index, "%"+document+"%");
						index++;
					}
					if(status!=null){
						cs.setString(++index, "%"+status.name()+"%");
					}
					return cs;
				}
			}, new CallableStatementCallback<List<Patient>>() {
				@Override
				public List<Patient> doInCallableStatement(CallableStatement cs)
						throws SQLException, DataAccessException {
					List<Patient> patients = new ArrayList<Patient>();

					ResultSet rs = cs.executeQuery();
					while (rs.next()) {
						Patient patient = getPatientFromResultSet(rs);
						patients.add(patient);
					}
					return patients;
				}
			});
			
			return Optional.ofNullable(patients);
		} catch (EmptyResultDataAccessException e) {
			logger.warn("No patient found with those parameters ");
			return Optional.empty();
		} catch (DataAccessException e) {
			logger.error("Database error", e);
			throw new DatabaseNurseAppException("Error getting patients",e);
		}
    }
    
    private String buildPatientsCallWithConditions(String name, String document, Status status) {
    	String nextClause  =  " WHERE ";
    	String sqlResult = SQL_GET_PATIENTS;
    	
    	if(name!=null) {
    		sqlResult+=nextClause+" name LIKE ? ";
    		nextClause = " OR ";
    	}
    	if(document!=null) {
    		sqlResult+=nextClause+" document LIKE ? ";
    		nextClause = " OR ";
    	}
    	
    	if(status!=null) {
    		sqlResult+=nextClause+" status LIKE ? ";
    	}
    	return sqlResult;
    }

    @Override
    public Integer registerPatientVitalSign(Integer idPatient, Integer idVitalSign, Integer valueVItalSign, String condition) {
    	  logger.info(SQL_INSERT_PATIENT_VITAL_ISIGN);
          logger.info("1:" + idPatient);
          logger.info("2:" + idVitalSign);
          logger.info("3:" + valueVItalSign);
          logger.info("4:" + condition);
          try {
              KeyHolder keyHolder = new GeneratedKeyHolder();
              getJdbcTemplate().update(new PreparedStatementCreator() {
                  public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                      PreparedStatement ps = connection.prepareStatement(SQL_INSERT_PATIENT_VITAL_ISIGN, new String[]{"id_history"});
                      ps.setInt(1, idPatient);
                      ps.setInt(2, idVitalSign);
                      ps.setInt(3, valueVItalSign);
                      ps.setString(4, condition);
                      return ps;
                  }
              }, keyHolder);
              Integer id = (Integer) keyHolder.getKey();
              
              return id;
          } catch (DataAccessException e) {
              logger.error("Database error", e);
              throw new DatabaseNurseAppException("pvs1070","Error in patien vital sign registration",e);
          }
    }
    
    @Override
    public Optional<List<PatientVitalSign>> getPatientHistoryVitalSign(String  document) {
        logger.info("SQL -> "+SQL_GET_PATIENT_HISTORY_VITAL_SIGN);
        logger.info("1: "+document);
    	try {
    		List<PatientVitalSign> patientVitalSigns = getJdbcTemplate().query(SQL_GET_PATIENT_HISTORY_VITAL_SIGN, new Object[] {document}, new PatientVitalSignMapper());
        	return Optional.ofNullable(patientVitalSigns);
    	}catch(EmptyResultDataAccessException e) {
    		logger.error("No vitls signs for patient document "+document);
    		return Optional.empty();
    	}
    }
    
    private class PatientVitalSignMapper implements RowMapper<PatientVitalSign> {
		@Override
		public PatientVitalSign mapRow(ResultSet rs, int rowNum) throws SQLException {
			return getPatientVitalSignFromResultSet(rs);
		}
	}
    
    private class PatientMapper implements RowMapper<Patient> {
		@Override
		public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
			return getPatientFromResultSet(rs);
		}
	}
	
    private PatientVitalSign getPatientVitalSignFromResultSet(ResultSet rs) throws SQLException{
    	
    	VitalSign vitalSign = new VitalSign();
    	vitalSign.setIdVitalSign(rs.getInt("id_vital_sign"));
    	vitalSign.setCode(rs.getString("code"));
    	vitalSign.setDescription(rs.getString("description"));
    	
    	Patient patient = new Patient();
    	patient.setCodPatient(rs.getInt("id_patient"));
    	patient.setDocument(rs.getString("document"));
    	patient.setBirthDate(rs.getDate("bithdate"));
    	patient.setName(rs.getString("name"));
    	patient.setStatus(Status.valueOf(rs.getString("patient_status")));
    	
    	PatientVitalSign patientVitalSign = new PatientVitalSignBuilder()
    	.idPatientVitalSign(rs.getInt("id_history"))
    	.valueVitalSign(rs.getInt("value_vital_sign"))
    	.registerDate(rs.getDate("register_date"))
    	.condition(rs.getString("condition_description"))
    	.status( Status.valueOf(rs.getString("status")))
    	.vitalSign(vitalSign)
    	.build();
		return patientVitalSign;
	}
    
	private Patient getPatientFromResultSet(ResultSet rs) throws SQLException{
		Patient patient = new Patient();
		patient.setCodPatient(rs.getInt("ID_PATIENT"));
		patient.setDocument(rs.getString("document"));
		patient.setName(rs.getString("name"));
		patient.setBirthDate(rs.getDate("bithdate"));
		String status = rs.getString("status");
		patient.setStatus(Status.valueOf(status));
		return patient;
		
		
	}
}
