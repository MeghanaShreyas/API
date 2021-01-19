package com.restassured.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restassured.basics.TestBase;
import com.restassured.utilities.RestUtilities;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC4_PutEmployeeRecord extends TestBase {
	String empname = RestUtilities.empName();
	String empSalary = RestUtilities.empSal();
	String empage = RestUtilities.empage();
	
	@BeforeClass
	public void getsingleEmployees()
	{
		logger.info("******** started TC2 ***********");
		//Specify base URI
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
		
		//Request object 
		httpRequest = RestAssured.given();
		
		JSONObject requestparams = new JSONObject();
		requestparams.put("employee_name", empname);
		requestparams.put("employee_salary", empSalary);
		requestparams.put("employee_age", empage);
		requestparams.put("profile_image", ":");
		
		httpRequest.header("Content-type","application/json");
		httpRequest.body(requestparams.toJSONString());
		response = httpRequest.request(Method.PUT,"/update"+3);		
	}
	@Test
	void checkResponsebody()
	{
		logger.info("********** checking responsebody********************");
		String Responsebody = response.getBody().asString();
		//logger.info(Responsebody);
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