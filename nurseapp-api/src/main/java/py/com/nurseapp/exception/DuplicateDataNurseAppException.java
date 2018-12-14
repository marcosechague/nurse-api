package py.com.nurseapp.exception;

public class DuplicateDataNurseAppException extends BaseNurseAppException {

	private static final long serialVersionUID = 21983791823L;
	
	public DuplicateDataNurseAppException() {
		super();
	}
	public DuplicateDataNurseAppException(String code) {
		super(code);
	}
	public DuplicateDataNurseAppException(String code, String message) {
		super(code, message);
	}
	public DuplicateDataNurseAppException(String code, Throwable cause) {
		super(code, cause);
	}
	public DuplicateDataNurseAppException( String code, String message, Throwable cause) {
		super(code, message, cause);
	}
	

}
