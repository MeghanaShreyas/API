package com.restassured.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restassured.basics.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC2_GetSingleEmployeeRecord extends TestBase{
	
	
	@BeforeClass
	public void getsingleEmployees()
	{
		logger.info("******** started TC2 ***********");
		//Specify base URI
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
		
		//Request object 
		httpRequest = RestAssured.given();
		
		//Response Object 
		response = httpRequest.request(Method.GET,"/employee/"+7927);
	}
	
	@Test
	void checkResponsebody()
	{
		logger.info("********** checking responsebody********************");
		String Responsebody = response.getBody().asString();
		Assert.assertEquals(Responsebody.contains("7927"), true);
		logger.info(Responsebody);
	}
	
	@Test
	void checkStatusCode()
	{
		logger.info("********** checking statuscode********************");
		int Statuscode = response.getStatusCode();
		//Assert.assertEquals(Statuscode, 200);
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
