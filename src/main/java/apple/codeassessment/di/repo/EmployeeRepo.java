package apple.codeassessment.di.repo;

import apple.codeassessment.model.Employee;

public interface EmployeeRepo {
	public Employee getEmployeeById(int id);
	public Employee addOrUpdateEmployee(Employee e);
	public boolean deleteEmployeeById(int id);	
}
