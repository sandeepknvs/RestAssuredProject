package Session04;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CheckForValidResponse {
	
	
	@Test
	public void getSingleUser()
	{
		//"https://api.stripe.com/v1/customers/cus_Smb7vokzWM8CIo";
		
		RequestSpecification reqSpec = RestAssured.given();
		
		reqSpec.baseUri("https://api.stripe.com");
		reqSpec.basePath("/v1/customers/cus_Smb7vokzWM8CIo");
		Response response = reqSpec.get();
		//validate Response Header
		
		String contenttype = response.header("Content-Type");
		String contenttype1 = response.getHeader("Content-Type");

		System.out.println(contenttype);
		System.out.println(contenttype1);
		
		Headers headers = response.getHeaders();
		
		for(Header h:headers)
		{
			System.out.println(h.getName()+":"+h.getValue());
		}

	}
}
