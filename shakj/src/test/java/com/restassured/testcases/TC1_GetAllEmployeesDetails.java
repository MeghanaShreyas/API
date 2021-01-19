package com.restassured.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restassured.basics.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC1_GetAllEmployeesDetails extends TestBase
{
	@BeforeClass
	public void getAllEmployees()
	{
		logger.info("******** started TC1 ***********");
		//Specify base URI
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
		
		//Request object 
		httpRequest = RestAssured.given();
		
		//Response Object 
		response = httpRequest.request(Method.GET,"/employees");
		
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
