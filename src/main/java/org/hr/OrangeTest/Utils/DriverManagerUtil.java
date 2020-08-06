package org.hr.OrangeTest.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DriverManagerUtil {

	static {
		
		System.setProperty("webdriver.chrome.driver", 
				"E:\\Selenium\\slnm_files\\chromedriver_win32\\chromedriver.exe");
	}
	public static WebDriver driver =new ChromeDriver();
	
	//now initiating constructor for managing memory overloading
	private DriverManagerUtil() {
		
	}
	
	//to test if DriverManagerUtil is ready
    @Test
	public static void TestDriverManager() {
		System.out.println("Driver Executed");
	}
	
}
