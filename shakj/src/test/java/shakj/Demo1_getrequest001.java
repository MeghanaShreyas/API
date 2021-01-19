package shakj;

import org.junit.Test;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo1_getrequest001 {

	
@Test
public void getweatherdetails()
{
	//Specify base URI
	RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
	
	//Request object 
	RequestSpecification httpRequest = RestAssured.given();
	
	//Response Object 
	Response response = httpRequest.request(Method.GET,"employee/hydrabad");
	//when there is no parameters to pass just type (Methods.Get,"/");
	
	
	//print response on console window
	String responsebody = response.getBody().asString();
	System.out.println("Response body is"+ responsebody);
	
	//check the response body contains city passed as parameter
	Assert.assertEquals(responsebody.contains(("hydrabad")),true);
	
	//retrive all values in json response and verify
	JsonPath jp = response.jsonPath();
	System.out.println(jp.get("city"));
	System.out.println(jp.get("temp"));
	System.out.println(jp.get("state"));
	System.out.println(jp.get("hills"));
	
	//status code
	int statuscode = response.getStatusCode();
	System.out.println("Status code is "+ statuscode);
	Assert.assertEquals(statuscode, 200);
	
	//statusLine
	String statusline = response.getStatusLine();
	System.out.println(statusline);
	
	//verifying the headers from response
	String content = response.header("Content-type");
	System.out.println(content);
	
	String contentencoding = response.header("content-encoding");
	System.out.println(contentencoding);

	//all the headers from response
	Headers allheader = response.headers();
	for(Header header:allheader)
	{  
		//this will extract all headers with key and value pair
		System.out.println(header.getName()+" "+header.getValue());
	}

	//basic authentication
	PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
	authscheme.setUserName("meghana");
	authscheme.setPassword("password123");
	RestAssured.authentication = authscheme;
	
}
}
