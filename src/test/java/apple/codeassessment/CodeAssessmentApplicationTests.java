package apple.codeassessment;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CodeAssessmentApplicationTests {    
	@LocalServerPort
	private Integer port;
	
	@BeforeEach
	public void setup() {
	    RestAssured.baseURI = "http://localhost";
	    RestAssured.port = this.port;
	    RestAssured.basePath = "/api";
	}
	
	@Test
	void TestCRUD() {
		given().get("/employee/1")
			.then().statusCode(404);
	
		
		with().contentType(ContentType.JSON)
				.body("{\"firstname\":\"test\", \"lastname\":\"test\"}").
		when().post("/employee")
	    .then().statusCode(200)
	        .assertThat().body("id", equalTo(1))
	        .body("firstname", equalTo("test"))
	        .body("lastname", equalTo("test"));
		
		given().get("/employee/1")
	    .then().statusCode(200)
	        .assertThat().body("id", equalTo(1))
	        .body("firstname", equalTo("test"))
	        .body("lastname", equalTo("test"));		
		
		with().contentType(ContentType.JSON)
				.body("{\"id\": \"1\", \"firstname\":\"test1\", \"lastname\":\"test1\"}").
		when().put("/employee")
	    .then().statusCode(200)
	        .assertThat().body("id", equalTo(1))
	        .body("firstname", equalTo("test1"))
	        .body("lastname", equalTo("test1"));
		
		with().contentType(ContentType.JSON)
				.body("{\"id\": \"2\", \"firstname\":\"test1\", \"lastname\":\"test1\"}").
		when().put("/employee")
	    .then().statusCode(404);

		given().delete("/employee/1")
        .then().statusCode(200).assertThat().body(equalTo("true"));
		
		given().get("/employee/1")
		.then().statusCode(404);
		
	}

	
}
