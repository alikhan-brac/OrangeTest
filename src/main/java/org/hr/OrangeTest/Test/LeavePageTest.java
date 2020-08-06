package org.hr.OrangeTest.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import org.hr.OrangeTest.DTO.AssignLvDTO;
import org.hr.OrangeTest.DataProvider.AssignLvDataProvider;
import org.hr.OrangeTest.Utils.DriverManagerUtil;
import org.hr.OrangeTest.Utils.XpathUtil;

public class LeavePageTest {

	public WebDriver driver = null;

	@Test(priority = 1)
	public void AssignLeavePage() throws InterruptedException {
		Thread.sleep(1000);
		driver = DriverManagerUtil.driver;
		driver.findElement(By.xpath(XpathUtil.DashBoardModule.AssignLeave)).click();
	}

	@Test(priority = 2, dataProvider = "assignLVdata", dataProviderClass = AssignLvDataProvider.class)
	public void AssignLeaveTest(List<AssignLvDTO> lvdata) throws InterruptedException {
		Thread.sleep(1000);

		for (AssignLvDTO lv : lvdata) {
			driver.findElement(By.xpath(XpathUtil.AssignLeaveModule.EmployeeName)).sendKeys(lv.getEmpNm());
			driver.findElement(By.xpath(XpathUtil.AssignLeaveModule.LeaveType)).sendKeys(lv.getLvTyp());
			
			//Picking From Date
			driver.findElement(By.xpath(XpathUtil.AssignLeaveModule.FromDate)).click();
			driver.findElement(By.xpath(XpathUtil.AssignLeaveModule.FromDateMonth)).click();
			String temp=lv.getFromMnt();
			Select FromMonth = new Select(driver.findElement(By.xpath(XpathUtil.AssignLeaveModule.FromDateMonth)));
			FromMonth.selectByVisibleText(temp);//(lv.getFromMnt());
			driver.findElement(By.xpath(XpathUtil.AssignLeaveModule.FromDateYear)).click();
			temp=lv.getFromYr();
			Select FromYear = new Select(driver.findElement(By.xpath(XpathUtil.AssignLeaveModule.FromDateYear)));
			FromYear.selectByVisibleText(temp);//(lv.getFromYr());
			WebElement FromdateWidget = driver.findElement(By.className(XpathUtil.AssignLeaveModule.FromDateDayClass));
			List<WebElement> fromcolumns = FromdateWidget.findElements(By.tagName("td"));
			temp=lv.getFromDay();
			for (WebElement cell : fromcolumns) {
				if (cell.getText().equals(temp)) {
					cell.findElement(By.linkText(temp)).click();
					break;
				}
			}
			
			//Picking To Date
			driver.findElement(By.xpath(XpathUtil.AssignLeaveModule.ToDate)).click();
			driver.findElement(By.xpath(XpathUtil.AssignLeaveModule.ToDateMonth)).click();
			Select ToMonth = new Select(driver.findElement(By.xpath(XpathUtil.AssignLeaveModule.ToDateMonth)));
			ToMonth.selectByVisibleText(lv.getToMnt());
			driver.findElement(By.xpath(XpathUtil.AssignLeaveModule.ToDateYear)).click();
			Select ToYear = new Select(driver.findElement(By.xpath(XpathUtil.AssignLeaveModule.ToDateYear)));
			ToYear.selectByVisibleText(lv.getToYr());
			WebElement TodateWidget = driver.findElement(By.className(XpathUtil.AssignLeaveModule.ToDateDayClass));
			List<WebElement> tocolumns = TodateWidget.findElements(By.tagName("td"));
			for (WebElement cell : tocolumns) {
				if (cell.getText().equals(lv.getToDay())) {
					cell.findElement(By.linkText(lv.getToDay())).click();
					break;
				}
			}

			driver.findElement(By.xpath(XpathUtil.AssignLeaveModule.Comment)).sendKeys(lv.getCmnt());
			driver.findElement(By.xpath(XpathUtil.AssignLeaveModule.AssignButton)).click();
		}
	}
	@Test(priority = 3)
	public void ClickConfirm() throws InterruptedException {
		Thread.sleep(1000);
		driver = DriverManagerUtil.driver;
		driver.findElement(By.xpath(XpathUtil.AssignLeaveModule.ConfirmClick)).click();
	}
	
}
