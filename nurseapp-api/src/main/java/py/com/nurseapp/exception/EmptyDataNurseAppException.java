package py.com.nurseapp.exception;

public class EmptyDataNurseAppException extends BaseNurseAppException{

	private static final long serialVersionUID = 12382738191L;
	protected String code ;
	
	public EmptyDataNurseAppException() {
		super();
		code = "u5000";
	}
	
	public EmptyDataNurseAppException(String code) {
		super();
		this.code = code;
	}
	
	public EmptyDataNurseAppException(String code,String message) {
		super(message);
		this.code = code;
	}
	public EmptyDataNurseAppException(String code, Throwable cause) {
		super(code,cause);
		this.code = code;
	}
	public EmptyDataNurseAppException( String code, String message, Throwable cause) {
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
