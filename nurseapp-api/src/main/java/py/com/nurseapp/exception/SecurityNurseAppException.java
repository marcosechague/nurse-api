package py.com.nurseapp.exception;

public class SecurityNurseAppException extends BaseNurseAppException{

	private static final long serialVersionUID = 123331431233L;
	
	public SecurityNurseAppException() {
		super();
		code = "se5000";
	}
	
	public SecurityNurseAppException(String code) {
		super();
		this.code = code;
	}
	
	public SecurityNurseAppException(String code,String message) {
		super(message);
		this.code = code;
	}
	public SecurityNurseAppException(String code, Throwable cause) {
		super(code,cause);
		this.code = code;
	}
	public SecurityNurseAppException( String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}
}
