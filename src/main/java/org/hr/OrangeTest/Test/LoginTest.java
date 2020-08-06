package org.hr.OrangeTest.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import org.hr.OrangeTest.DTO.LoginDTO;
import org.hr.OrangeTest.DataProvider.LoginDataProvider;
import org.hr.OrangeTest.Utils.DriverManagerUtil;
import org.hr.OrangeTest.Utils.UrlTextUtil;
import org.hr.OrangeTest.Utils.XpathUtil;

public class LoginTest {
	public WebDriver driver=null;
	
	@Test(priority = 1)
	public void CheckPgTitle() {
		driver=DriverManagerUtil.driver;
		driver.get(UrlTextUtil.Url.baseURL);
		Assert.assertEquals(driver.getTitle(), UrlTextUtil.TEXT.HmPgTtl);
	}
	
	@Test(dependsOnMethods ="CheckPgTitle",dataProvider = "loginData",dataProviderClass = LoginDataProvider.class)
	public void logintest(List<LoginDTO> lgdata) 
	{
		for(LoginDTO lg : lgdata) 
		{
			driver.findElement(By.xpath(XpathUtil.LoginModule.user_name)).sendKeys(lg.getUsername());
			driver.findElement(By.xpath(XpathUtil.LoginModule.pass)).sendKeys(lg.getPassword());
			driver.findElement(By.xpath(XpathUtil.LoginModule.login_btn)).click();
		}
	}
}