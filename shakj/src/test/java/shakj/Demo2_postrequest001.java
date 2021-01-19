package shakj;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo2_postrequest001
{
@Test
public void postweatherdetails()
{
	
	//Specify base URI
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
		
		//Request object 
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request parameters
		JSONObject requestParams = new JSONObject();
		requestParams.put("FN", "megjana");
		requestParams.put("LN", "msjsdh");
		requestParams.put("State", "mdjmskfana");
		requestParams.put("School", "vhp");
		
		httpRequest.header("Content-Type","application.json");
		httpRequest.body(requestParams.toJSONString());
		
		
		Response response = httpRequest.request(Method.POST,"register");
		
		//print response on console window
		String responsebody = response.getBody().asString();
		System.out.println("Response body is"+ responsebody);
		
		//status code
		int statuscode = response.getStatusCode();
		System.out.println("Status code is "+ statuscode);
		Assert.assertEquals(statuscode, 200);	
	
		String sucesscodevalidation = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(sucesscodevalidation,"operation success");
}
}
