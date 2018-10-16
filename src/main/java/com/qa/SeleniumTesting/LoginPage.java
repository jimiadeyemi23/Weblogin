package com.qa.SeleniumTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
	WebElement username;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")	
	WebElement password;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")
	WebElement submit;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	WebElement Message;
	
	
	

	
	public void InputUserName(String uname) throws InterruptedException
	{
		username.sendKeys(uname);	
	}
	
	public void InputPassword(String pass)
	{
		password.sendKeys(pass);
		submit.submit();
	}
	
	public WebElement get_Username()
	{
		return username;
		
	}
	
	public String  get_Password()
	{
		return Message.getText();
		
	}
	
}
