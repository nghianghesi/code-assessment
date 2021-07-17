package apple.codeassessment.dto;

public class Employee {
	private int id;
	private String firstname;
	private String lastname;
	
	public int getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}
	
	public static Employee fromModel(apple.codeassessment.model.Employee e) {
		Employee dto = new Employee();
		dto.id = e.getId();
		dto.firstname = e.getFirstname();
		dto.lastname = e.getLastname();
		return dto;
	}	
	
	public apple.codeassessment.model.Employee toModel() {
		return new apple.codeassessment.model.Employee(this.id, this.firstname, this.lastname);
	}	
	
	public apple.codeassessment.model.Employee toInsertedModel() {
		return new apple.codeassessment.model.Employee(0, this.firstname, this.lastname);
	}	
	
}

