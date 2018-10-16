package com.qa.SeleniumTesting;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class DemoTesting 
{
	public WebDriver driver = null;
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void CreateUser() throws InterruptedException, IOException
	{
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
		assertEquals("**Successful Login**",lp.get_Password());

	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
}
