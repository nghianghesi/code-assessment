package apple.codeassessment.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import apple.codeassessment.di.service.EmployeeService;
import apple.codeassessment.exception.EmployeeNotFoundException;
import apple.codeassessment.model.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	@GetMapping(path = "/{id}")
	public apple.codeassessment.dto.Employee getEmployeeById(@PathVariable int id) throws EmployeeNotFoundException {
		return apple.codeassessment.dto.Employee.fromModel(this.employeeService.getEmployeeById(id));
	}

	@PutMapping
	public apple.codeassessment.dto.Employee updateEmployee(@RequestBody apple.codeassessment.dto.Employee e)
			throws EmployeeNotFoundException {
		Employee updatedEmployee = this.employeeService.addOrUpdateEmployee(e.toModel());
		return apple.codeassessment.dto.Employee.fromModel(updatedEmployee);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public apple.codeassessment.dto.Employee insertEmployee(@RequestBody apple.codeassessment.dto.Employee e) {
		Employee updatedEmployee = this.employeeService.addOrUpdateEmployee(e.toInsertedModel());
		return apple.codeassessment.dto.Employee.fromModel(updatedEmployee);
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
