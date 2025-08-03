package day1;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPRequest {
	@Test
	void getUser()
	{
		when().get("https://reqres.in/api/users/2")
		
		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();
	}
	
	@Test(priority=1)
	void createUsers()
	{
		HashMap<String, String> hm = new HashMap<>();
		hm.put("name","sandeep");
		hm.put("job","Test Engineer");
		
		given().contentType("application/json")
		.accept("application/json")
		.body(hm)
		
		.when().post("https://reqres.in/api/users")
		
		.then().statusCode(201).log().all();
		
		
	}
}
