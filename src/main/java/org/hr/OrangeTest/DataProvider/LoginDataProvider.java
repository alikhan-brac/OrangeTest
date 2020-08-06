package org.hr.OrangeTest.DataProvider;

import java.io.IOException;

import org.hr.OrangeTest.Utils.ExcelUtil;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {
	
	@DataProvider(name="loginData")
	public static Object[][] getLoginData()
	{
		try 
		{
			return new Object[][]
				{
					{ExcelUtil.getLoginData()},
				};
		}catch(IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}