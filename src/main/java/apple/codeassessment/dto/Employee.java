package apple.codeassessment.dto;

public class Employee {
	private int id;
	private String firstname;
	private String lastname;
	private int salary;
	
	public int getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public int getSalary() {
		return salary;
	}

	
	public static Employee fromModel(apple.codeassessment.model.Employee e) {
		Employee dto = new Employee();
		dto.id = e.getId();
		dto.firstname = e.getFirstname();
		dto.lastname = e.getLastname();
		dto.salary = e.getSalary();
		return dto;
	}	
	
	public apple.codeassessment.model.Employee toModel() {
		return new apple.codeassessment.model.Employee(this.id, this.firstname, this.lastname, this.salary);
	}	
	
	public apple.codeassessment.model.Employee toInsertedModel() {
		return new apple.codeassessment.model.Employee(0, this.firstname, this.lastname, this.salary);
	}	
	
}

