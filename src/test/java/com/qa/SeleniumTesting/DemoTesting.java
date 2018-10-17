package com.qa.SeleniumTesting;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoTesting 
{
	public WebDriver driver = null;
	
	static ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\Reports\\Report.html", true);
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
		test.log(LogStatus.INFO, "started test");
		
		driver.get("http://thedemosite.co.uk/addauser.php");
		CreateUserPage cup = PageFactory.initElements(driver, CreateUserPage.class);
		cup.InputUserName("jimi");
		cup.InputPassword("jimi");
		//assertEquals("jimi",cup.get_Username());
		//assertEquals("jimi",cup.get_Password());
		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.InputUserName("jimi");
		lp.InputPassword("jimi");
		
		//assertEquals("jimi",lp.get_Username());
		
		if(lp.get_Password().equals("**Successful Login**"))
		{
			test.log(LogStatus.PASS, "login successful");
		}
		else
		{
			test.log(LogStatus.FAIL, "login failed");
		}
		assertEquals("**Successful Login**",lp.get_Password());

	}
	
	@After
	public void tearDown()
	{
		//driver.quit();
	}
}
