package com.qa.SeleniumTesting;

import static org.junit.Assert.assertEquals;

import java.awt.Desktop.Action;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class WriteName 
{
	
	public WebDriver driver = null;
	static ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\Reports\\name.html", true);
	ExtentTest test;
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void CreateUser() throws InterruptedException, IOException
	{
		test = extent.startTest("verify application");
		
		test.log(LogStatus.INFO, "Mouse released");
		
		driver.get("https://www.youidraw.com/apps/painter/");		
		Actions action = new Actions(driver);		
		action.moveByOffset(200, 200).clickAndHold().moveByOffset(-150, 0).release().perform();
		action.moveByOffset(75, 0).clickAndHold().moveByOffset(0, 200).release().perform();
		action.moveByOffset(-75, 0).clickAndHold().moveByOffset(50, 0).release().perform();
		
	
		
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@AfterClass
	public static void end()
	{
		extent.flush();
	}
}
