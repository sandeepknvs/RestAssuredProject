package Session03;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class Test_GetMethod {
	@Test
	public void Test01()
	{
		given().header("Authorization","Bearer sk_test_51Qhx7kCE75m07UUcYnFJiu0EWLMf72IryOfNoAtHMuohzjsStmOga2TsRidYY6ACJPEQzjzD2QCB6LGzmBFn7Igl00XExus2Ju")
		
		.when().get("https://api.stripe.com/v1/customers")
		.then().statusCode(200).log().all();
	}
	
	//@Test
	public void Test02()
	{
		given().header("Authorization","Bearer sk_test_51Qhx7kCE75m07UUcYnFJiu0EWLMf72IryOfNoAtHMuohzjsStmOga2TsRidYY6ACJPEQzjzD2QCB6LGzmBFn7Igl00XExus2Ju")
		.formParam("name", "chaturveda").formParam("email", "chatur@mail.com").formParam("description", "i look like joshna")
		.when().post("https://api.stripe.com/v1/customers")
		.then().statusCode(200).log().all();
	}
	//@Test
	public void Test03()
	{
		given().header("Authorization","Bearer sk_test_51Qhx7kCE75m07UUcYnFJiu0EWLMf72IryOfNoAtHMuohzjsStmOga2TsRidYY6ACJPEQzjzD2QCB6LGzmBFn7Igl00XExus2Ju")
		.when().delete("https://api.stripe.com/v1/customers/cus_Smb1Sg0jorrRw9")
		.then().statusCode(200).log().all();
	}
	
	//@Test
	public void Test04()
	{
		given().header("Authorization","Bearer sk_test_51Qhx7kCE75m07UUcYnFJiu0EWLMf72IryOfNoAtHMuohzjsStmOga2TsRidYY6ACJPEQzjzD2QCB6LGzmBFn7Igl00XExus2Ju")
		.formParam("name", "chaturrrr")
		.when().post("https://api.stripe.com/v1/customers/cus_Smb7vokzWM8CIo")
		.then().statusCode(200).log().all();
	}
}
