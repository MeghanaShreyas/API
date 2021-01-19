package shakj;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo3_apidatadriven {

	
	@Test(dataProvider = "multipledatasets")
	public void postemployees(String ename, String eage,String esalary,String dob)
	{

		//Specify base URI
			RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
			
			//Request object 
			RequestSpecification httpRequest = RestAssured.given();
			
			//Request parameters
			JSONObject requestParams = new JSONObject();
			
			//with single sets of data
			requestParams.put("name", "meghana");
			requestParams.put("salary", "234");
			requestParams.put("age", 12);
			
			//with multiple sets of data
			requestParams.put("name", ename);
			requestParams.put("salary", eage);
			requestParams.put("age", esalary);
			requestParams.put("dob", dob);
			//adding header stating the request body is a json
			httpRequest.header("Content-type","application/json");
			
			//add json to body of the request
			httpRequest.body(requestParams.toJSONString());
			
			Response response = httpRequest.request(Method.POST,"/create");
			
			String responsebody = response.getBody().asString();
			Assert.assertEquals(responsebody.contains("200"),true);
			//System.out.println(responsebody);
			
	}
	
	//with multiple sets of data using Data provider
		@DataProvider(name = "multipledatasets")
			public Object[][] getData() throws IOException
			{
		
			//reading data from excel
			String path = "C:\\Users\\User\\eclipse-workspace\\shakj\\src\\test\\java\\shakj\\empdata.xlsx";
			int rows = Xlutils.getRowCount(path, "Employee");
			int column = Xlutils.getCellCount(path, "Employee", 1);
			System.out.println(rows+" "+column);
			int row = rows+1;
			String empdata[][] = new String[rows][column];
			
			for(int i = 0;i<row;i++)
			{
				for(int j = 0;j<column;j++)
				{
					empdata[i][j] = Xlutils.getCellData(path, "Employee", i, j);
				}
			}
			
				
			//	Object[][] data = {{"1bc","20000","20"},
	//			{"jhgdj","7238","3638"}};
				return (empdata);
			
}

}
