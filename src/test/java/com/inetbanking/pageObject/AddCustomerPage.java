package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage 
{
	WebDriver idriver;
	public AddCustomerPage(WebDriver rdriver)
	{
		idriver=rdriver;
		PageFactory.initElements(rdriver,this);
	 }
	@FindBy(how=How.XPATH,using="//a[text()='New Customer']")
	@CacheLookup
	WebElement  linkAddNewCust;
	@FindBy(how=How.NAME, using="name")
	@CacheLookup
	WebElement  txtCustomerName;
	@FindBy(how=How.NAME, using="rad1")
	@CacheLookup
	WebElement  rdGender;
	@FindBy(how=How.ID_OR_NAME,using="dob")
	@CacheLookup
	WebElement  txtDOB;
	@FindBy(how=How.NAME,using="addr")
	@CacheLookup
	WebElement  txtAddress;
	
	@FindBy(how=How.NAME,using="city")
	@CacheLookup
	WebElement  txtCity;
	@FindBy(how=How.NAME,using="state")
	@CacheLookup
	WebElement  txtState;
	@FindBy(how=How.NAME,using="pinno")
	@CacheLookup
	WebElement  txtPinNo;
	
	@FindBy(how=How.NAME,using="telephoneno")
	@CacheLookup
	WebElement  txtTelephoneNo;
	@FindBy(how=How.NAME,using="emailid")
	@CacheLookup
	WebElement  txtEmailID;
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement  txtPassword;
	
	@FindBy(how=How.NAME,using="sub")
	@CacheLookup
	WebElement  txtSubmitBtn;
	
	public void clickAddNewCustometer()
	{
		linkAddNewCust.click();
	}
	
	public void custName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	public void custGender(String cgender)
	{
		rdGender.click();
	}
	public void custdob(String mm,String dd,String yy)
	{
		txtDOB.sendKeys(mm);
		txtDOB.sendKeys(dd);
		txtDOB.sendKeys(yy);
	}
	public void custaddress(String caddress)
	{
		txtAddress.sendKeys(caddress);
	}
	public void custcity(String ccity)
	{
		txtCity.sendKeys(ccity);
	}
	public void custstate(String cstate)
	{
		txtState.sendKeys(cstate);
	}
	public void custpinno(String cpinno)
	{
		txtPinNo.sendKeys(String.valueOf(cpinno));
	}
	public void custtelephoneno(String ctelephoneno)
	{
		txtTelephoneNo.sendKeys(ctelephoneno);
	}
	public void custemailid(String cemailid)
	{
		txtEmailID.sendKeys(cemailid);
	}
	public void custpassword(String cpassword)
	{
		txtPassword.sendKeys(cpassword);
	}
	public void custsubmit()
	{
		txtSubmitBtn.click();
	}
}
