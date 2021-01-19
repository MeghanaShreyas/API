package shakj;

import org.testng.annotations.DataProvider;

public class Demo4_apidatadrivenmultipledatasets {
@DataProvider(name="multipledatasets")
			public Object[][] getData()
		{
			Object[][] data = {{"abc@gmail.com","abc"},{"meg@gmail.com","meg"}};
			return data;
		}
		
		
		
		
	}
	
	
	
	