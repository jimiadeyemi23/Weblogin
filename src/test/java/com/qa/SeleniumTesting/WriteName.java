package com.qa.SeleniumTesting;

import static org.junit.Assert.assertEquals;

import java.awt.Desktop.Action;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class WriteName 
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
		driver.get("https://www.youidraw.com/apps/painter/");
		
		Actions action = new Actions(driver);		
		action.moveByOffset(200, 200).clickAndHold().moveByOffset(-150, 0).release().perform();
		action.moveByOffset(75, 0).clickAndHold().moveByOffset(0, 200).release().perform();
		action.moveByOffset(-75, 0).clickAndHold().moveByOffset(50, 0).release().perform();
	

	}
	
	@After
	public void tearDown()
	{
		//driver.quit();
	}
}
