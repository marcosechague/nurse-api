package py.com.nurseapp.exception;

public class ApplicationNurseAppException extends BaseNurseAppException {

	private static final long serialVersionUID = 1827812398193L;
	
	public ApplicationNurseAppException() {
		super();
	}
	public ApplicationNurseAppException(String code) {
		super(code);
	}
	public ApplicationNurseAppException(String code, String message) {
		super(code, message);
	}
	public ApplicationNurseAppException(String code, Throwable cause) {
		super(code, cause);
	}
	public ApplicationNurseAppException( String code, String message, Throwable cause) {
		super(code, message, cause);
	}
	

}
