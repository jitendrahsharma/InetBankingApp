package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver idriver;
	public LoginPage(WebDriver rdriver)
	{
		idriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	@FindBy(name="uid")
	@CacheLookup
	WebElement  textUserName;
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;
	public void setUserName(String uName)
	{
		textUserName.sendKeys(uName);;
	}
	public void setUserPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);;
	}
	public void clickSubmit()
	{
		btnLogin.click();
	}
	public void clickLogout()
	{
		lnkLogout.click();
	}
}

