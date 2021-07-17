package apple.codeassessment.exception;

public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7119061270942857629L;

	public EmployeeNotFoundException(int id) {
		super("Could not find employee " + id);
	}
}
