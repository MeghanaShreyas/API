package com.restassured.basics;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TestBase {

	public RequestSpecification httpRequest;
	public Response response;
	public Logger logger;
	@BeforeClass
	public void setup()
	{
		logger = Logger.getLogger("Test");
		PropertyConfigurator.configure("log4j.properties");
	}
	
		
		
}