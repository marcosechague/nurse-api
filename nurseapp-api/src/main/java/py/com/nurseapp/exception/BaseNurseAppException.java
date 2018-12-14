package py.com.nurseapp.exception;

public class BaseNurseAppException extends RuntimeException{
	
	private static final long serialVersionUID = 138729388328L;
	protected String code ;
	
	public BaseNurseAppException() {
		super();
		code = "u5000";
	}
	
	public BaseNurseAppException(String code) {
		super();
		this.code = code;
	}
	
	public BaseNurseAppException(String code,String message) {
		super(message);
		this.code = code;
	}
	public BaseNurseAppException(String code, Throwable cause) {
		super(cause);
		this.code = code;
	}
	public BaseNurseAppException( String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
