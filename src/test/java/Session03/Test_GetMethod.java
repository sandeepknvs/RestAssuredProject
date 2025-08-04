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
		given()
		
		.when().get("https://api.stripe.com/v1/customers")
		.then().statusCode(200).log().all();
	}
	
	//@Test
	public void Test02()
	{
		given()
		.formParam("name", "chaturveda").formParam("email", "chatur@mail.com").formParam("description", "i look like joshna")
		.when().post("https://api.stripe.com/v1/customers")
		.then().statusCode(200).log().all();
	}
	//@Test
	public void Test03()
	{
		given()
		.when().delete("https://api.stripe.com/v1/customers/cus_Smb1Sg0jorrRw9")
		.then().statusCode(200).log().all();
	}
	
	//@Test
	public void Test04()
	{
		given()
		.formParam("name", "chaturrrr")
		.when().post("https://api.stripe.com/v1/customers/cus_Smb7vokzWM8CIo")
		.then().statusCode(200).log().all();
	}
}
