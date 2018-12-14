package py.com.nurseapp.exception;

public class DatabaseNurseAppException extends BaseNurseAppException {

	private static final long serialVersionUID = 32984728388L;
	
	public DatabaseNurseAppException() {
		super();
	}
	public DatabaseNurseAppException(String code) {
		super(code);
	}
	public DatabaseNurseAppException(String code, String message) {
		super(code, message);
	}
	public DatabaseNurseAppException(String code, Throwable cause) {
		super(code, cause);
	}
	public DatabaseNurseAppException( String code, String message, Throwable cause) {
		super(code, message, cause);
	}
	

}
