package apple.codeassessment.service;

import org.springframework.beans.factory.annotation.Autowired;

import apple.codeassessment.di.repo.EmployeeRepo;
import apple.codeassessment.exception.EmployeeNotFoundException;
import apple.codeassessment.model.Employee;

public class EmployeeService implements apple.codeassessment.di.service.EmployeeService{
	@Autowired
	EmployeeRepo employeeRepo;
	
	private Employee loadEmployeeByIdOrThrowNotFound(int id) throws EmployeeNotFoundException {
		Employee e = this.employeeRepo.getEmployeeById(id);
		
		if(e != null)
		{
			return e;
		}else {
			throw new EmployeeNotFoundException(id);
		}
	}
	
	@Override
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
		return this.loadEmployeeByIdOrThrowNotFound(id);
	}

	@Override
	public Employee addOrUpdateEmployee(Employee e) throws EmployeeNotFoundException {
		Employee updatedEmployee = this.employeeRepo.addOrUpdateEmployee(e);
		if (updatedEmployee == null)
		{
			throw new EmployeeNotFoundException(e.getId());
		}
		
		return updatedEmployee;
	}

	@Override
	public boolean deleteEmployeeById(int id) throws EmployeeNotFoundException {
		this.loadEmployeeByIdOrThrowNotFound(id);
		return this.employeeRepo.deleteEmployeeById(id);
	}

}
