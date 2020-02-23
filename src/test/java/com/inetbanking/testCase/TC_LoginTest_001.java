package com.inetbanking.testCase;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{

	
	@Test
	public void loginTest() throws IOException
	{
		logger.info("URL is oppend");
		miximizePage();
		deleteCookies();
		driver.manage().deleteAllCookies();
		LoginPage loginpage=new LoginPage(driver);
		loginpage.setUserName(username);
		logger.info("User name is provided");
		loginpage.setUserPassword(password);
		logger.info("Password is provided");
		loginpage.clickSubmit();
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage!!!"))
		{
			Assert.assertTrue(true);
			logger.info("Login test case Passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test case Failed");
			
			
			
		}
	}

}
