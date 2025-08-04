package session06;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateJSONResponse {
	
	@Test
	public void ValidateJSONResponse()
	{
		
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://api.stripe.com");
		reqSpec.basePath("/v1/customers");
		Response response = reqSpec.get();
		
		ResponseBody responsebody = response.getBody();
		String responseString = responsebody.asString();
		System.out.println(responseString);
		
		JsonPath jsonpathfinder = responsebody.jsonPath();
		String firstName = jsonpathfinder.get("data[1].name");
		Assert.assertEquals(firstName , "veda","Please Check for firstname");
	}

}
