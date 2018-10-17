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

import net.sf.cglib.core.EmitUtils;

public class ExcelTest 
{

	public WebDriver driver = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		
	}

	@Before
	public void setUp() throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		
		Read.setExcelFile(Constants.path, 0);
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
			driver.get("http://thedemosite.co.uk/addauser.php");
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
				
			}
			
			assertEquals(eresult,lp.get_Password());
			Read.setCellData("pass", i, 4);
		}
	}

}
