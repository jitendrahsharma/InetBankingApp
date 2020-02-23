package com.inetbanking.testCase;

import java.io.IOException;

import org.testng.annotations.Test;
import com.inetbanking.pageObject.AddCustomerPage;
import com.inetbanking.pageObject.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass
{
@Test
public void addNewCustomer() throws InterruptedException, IOException
{
	logger.info("URL is oppend");
	miximizePage();
	deleteCookies();
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(username);
	logger.info("User name is provided");
	lp.setUserPassword(password);
	logger.info("Password is provided");
	lp.clickSubmit();
	logger.info("Login successfully....");
	
	Thread.sleep(3000);
	
	AddCustomerPage addcust=new AddCustomerPage(driver);
	
	logger.info("Providing customer details....");
	
	addcust.clickAddNewCustometer();
	addcust.custName("jitendra");
	addcust.custGender("male");
	addcust.custdob("10","15","1992");
	Thread.sleep(3000);
	
	addcust.custaddress("INDIA");
	addcust.custcity("Mu");
	addcust.custstate("MH");
	addcust.custpinno("123457");
	String contact=randomNum();
	addcust.custtelephoneno(contact);
	
    String email=	randomstring()+"@gmail.com";
     addcust.custemailid(email);
     addcust.custpassword("test1234@");
     addcust.custsubmit();
     
     Thread.sleep(3000);
     logger.info("Validation started....");
 	
     boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
     if(res==true)
     {
    	 Assert.assertTrue(true);
    	 logger.info("Test case passed....");
    		
     }
     else
     {
    	 Assert.assertTrue(false);
    	 logger.info("Test case failed....");
    	 captureScreen(driver,"addNewCustomer");
    	
    
     }
     
}
}
