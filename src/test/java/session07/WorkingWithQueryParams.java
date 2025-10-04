package session07;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class WorkingWithQueryParams {
	
	@Test
	public void queryParams() {
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://api.stripe.com");
		reqSpec.basePath("/v1/customers");
		reqSpec.header("Authorization","Bearer sk_test_51Qhx7kCE75m07UUcYnFJiu0EWLMf72IryOfNoAtHMuohzjsStmOga2TsRidYY6ACJPEQzjzD2QCB6LGzmBFn7Igl00XExus2Ju");
		//reqSpec.queryParam("limit", 5);
		//reqSpec.queryParam("id", "cus_Smb7vokzWM8CIo");
		Response response = reqSpec.get();
		
		ResponseBody responsebody = response.getBody();
		
		String responseString = responsebody.asString();
		System.out.println(responseString);
	}

}
