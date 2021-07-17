package apple.codeassessment.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import apple.codeassessment.di.service.EmployeeService;
import apple.codeassessment.exception.EmployeeNotFoundException;
import apple.codeassessment.model.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	private apple.codeassessment.dto.Employee toDTO(Employee e) {
		return new apple.codeassessment.dto.Employee(e.getId(), e.getFirstname(), e.getLastname());
	}

	private Employee fromDTO(apple.codeassessment.dto.Employee e) {
		return new Employee(e.getId(), e.getFirstname(), e.getLastname());
	}

	@GetMapping(path = "/{id}")
	public apple.codeassessment.dto.Employee getEmployeeById(@PathVariable int id) throws EmployeeNotFoundException {
		return toDTO(this.employeeService.getEmployeeById(id));
	}

	@PutMapping
	public apple.codeassessment.dto.Employee updateEmployee(@RequestBody apple.codeassessment.dto.Employee e)
			throws EmployeeNotFoundException {
		Employee updatedEmployee = this.employeeService.addOrUpdateEmployee(fromDTO(e));
		return toDTO(updatedEmployee);
	}

	@PostMapping
	public apple.codeassessment.dto.Employee insertEmployee(@RequestBody apple.codeassessment.dto.Employee e) {
		e.setId(-1);
		Employee updatedEmployee = this.employeeService.addOrUpdateEmployee(fromDTO(e));
		return toDTO(updatedEmployee);
	}

	@DeleteMapping(path = "/{id}")
	public boolean deleteEmployeeById(@PathVariable int id) throws EmployeeNotFoundException {
		return this.employeeService.deleteEmployeeById(id);
	}

	@ResponseBody
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(EmployeeNotFoundException ex) {
		return ex.getMessage();
	}
}
