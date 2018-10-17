package com.qa.SeleniumTesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import net.sf.cglib.core.EmitUtils;

public class ExcelTest 
{

	public WebDriver driver = null;
	
	static ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\Reports\\Report.html", true);
	ExtentTest test;
	
	@Before
	public void setUp() throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		
		Read.setExcelFile(Constants.path, 0);
	}
	
	@AfterClass
	public static void end()
	{
		extent.flush();
	}

	@After
	public void tearDown() throws Exception 
	{
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException
	{

		for(int i = 1; i < Read.getExcelWSheet().getPhysicalNumberOfRows(); i++)
		{	
			test = extent.startTest("Browser started right" + i);
			
			driver.get("http://thedemosite.co.uk/addauser.php"); //go to website
			CreateUserPage cup = PageFactory.initElements(driver, CreateUserPage.class);
			
			String user = Read.getCellData(i, 0);
			String password = Read.getCellData(i, 1);
			String eresult = Read.getCellData(i, 2);
			
			cup.InputUserName(user);
			cup.InputPassword(password);
			
			
			LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
			lp.InputUserName(user);
			lp.InputPassword(password);
			if (!lp.get_Password().equals(eresult))
			{
				test.log(LogStatus.INFO.FAIL, "Incorrect details");
			}
			else 
			{
				test.log(LogStatus.INFO.PASS, "Correct details");
				assertEquals(eresult,lp.get_Password());
				
				Read.setCellData("pass", i, 4);
			}

		}
	}

}
