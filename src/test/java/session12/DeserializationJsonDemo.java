package session12;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class DeserializationJsonDemo {
	
	@Test
	public void createCustomer()
	{
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.baseUri("https://api.stripe.com");
		requestSpec.basePath("v1/customers/cus_Smb7vokzWM8CIo");
	}

}
