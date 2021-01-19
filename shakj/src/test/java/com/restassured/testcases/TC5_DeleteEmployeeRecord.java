package com.restassured.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restassured.basics.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC5_DeleteEmployeeRecord extends TestBase {
	@BeforeClass
	public void getsingleEmployees()
	{
		logger.info("******** started TC2 ***********");
		//Specify base URI
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
		
		//Request object 
		httpRequest = RestAssured.given();

		response = httpRequest.request(Method.GET,"/employees");
		
		//get the jsonpath object instance from response interface
		JsonPath jsonpathevaluator = response.jsonPath();
		
		String empid = jsonpathevaluator.get("{0}.id");
		response = httpRequest.request(Method.DELETE,"/delete/"+empid);
	
	
	}

	@Test
	void checkResponsebody()
	{
		logger.info("********** checking responsebody********************");
		String Responsebody = response.getBody().asString();
		logger.info(Responsebody);
	}
	
	@Test
	void checkStatusCode()
	{
		logger.info("********** checking statuscode********************");
		int Statuscode = response.getStatusCode();
		Assert.assertEquals(Statuscode, 200);
		logger.info("Status code is ===="+ Statuscode);
		
	}
	
	@Test
	void contenttype()
	{
		logger.info("******************* content - type ********************");
		String content= response.header("Content-Type");
		logger.info(content);
		
	}
	
	@AfterClass
	void last()
	{
		logger.info("************888 finished**************");
		
		
	




}


}




