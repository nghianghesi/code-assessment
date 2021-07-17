package apple.codeassessment.di.service;

import apple.codeassessment.exception.EmployeeNotFoundException;
import apple.codeassessment.model.Employee;

public interface EmployeeService {
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException;
	public Employee addOrUpdateEmployee(Employee e) throws EmployeeNotFoundException;
	public boolean deleteEmployeeById(int id) throws EmployeeNotFoundException;	
}
