package apple.codeassessment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CodeAssessmentApplicationTests {    
	@LocalServerPort
	private Integer port;
	  
	@Test
	void TestCRUD() {
		RestAssured.
		given().get("/employee/1")
        .then().statusCode(404);
	}

}
