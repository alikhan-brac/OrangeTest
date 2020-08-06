package org.hr.OrangeTest.DataProvider;

import java.io.IOException;

import org.hr.OrangeTest.Utils.ExcelUtil;
import org.testng.annotations.DataProvider;

public class AssignLvDataProvider {
	
	@DataProvider(name="assignLVdata")
	public static Object[][] getAssignLvData()
	{
		try 
		{
			return new Object[][]
				{
					{ExcelUtil.getAssignLvData()},
				};
		}catch(IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
