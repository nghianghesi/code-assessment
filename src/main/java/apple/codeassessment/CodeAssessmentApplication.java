package apple.codeassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import apple.codeassessment.di.repo.EmployeeRepo;
import apple.codeassessment.di.service.EmployeeService;

@SpringBootApplication
public class CodeAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeAssessmentApplication.class, args);
	}

	@Bean
	public EmployeeService getEmployeeService() {
		return new apple.codeassessment.service.EmployeeService();
	}
	
	@Bean
	public EmployeeRepo getEmployeeRepo() {
		return new apple.codeassessment.repo.MemoryStorageEmployeeRepo();
	}	
}
