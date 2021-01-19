package com.restassured.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtilities {

	public static String empName()
	{
		String generateString = RandomStringUtils.randomAlphabetic(1);
		return("Meghana"+ generateString);
		
	}


		public static String empSal()
		{
			String generateString = RandomStringUtils.randomNumeric(5);
					return(generateString);
			
		}

			public static String empage()
			{
				String generateString = RandomStringUtils.randomNumeric(2);
				return(generateString);
				
			}


}
