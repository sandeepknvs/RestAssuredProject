package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndPoints;
import api.payload.user;
import io.restassured.response.Response;

public class UserTest {
	Faker faker;
	user userPayload;
	
	@BeforeClass
	//@Test
	public void generateTestData()
	{
		faker = new Faker();
		userPayload = new user();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	}
	
	@Test(priority = 1)
	public void testCreateUser()
	{
		System.out.println("Creating User Data");
		Response response =  userEndPoints.createUser(userPayload);
		response.then().log().all();
		
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2)
	public void testGetUserData()
	{
		System.out.println("Getting User Data");
		Response response =  userEndPoints.getUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void testUpdateUserData()
	{
		System.out.println("Updating User Data");
		userPayload.setFirstname(faker.name().firstName());
		Response response =  userEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Response responsePostUpdate = userEndPoints.getUser(this.userPayload.getUsername());

		System.out.println("After Update User Data.");

		responsePostUpdate.then().log().all();

	}
	
	@Test(priority = 4)
	public void testDeleteUserData()
	{
		System.out.println("Deleting User Data");
		System.out.println("Deleting user: " + this.userPayload.getUsername());
		Response response =  userEndPoints.deleteUser(this.userPayload.getUsername());
		response.then().log().all();
		

		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
