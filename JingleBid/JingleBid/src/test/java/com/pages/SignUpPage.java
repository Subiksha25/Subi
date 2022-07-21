package com.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.basepage.BasePage;
import com.context.Constants;
import com.github.javafaker.Faker;
import com.helper.SeleniumHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.util.ReportUtil;
import com.util.TestProperties;

public class SignUpPage extends BasePage{

	SeleniumHelper seleniumHelper;
	Constants constants;

	@FindBy(xpath= "//div[@class='fs-11 fw-600 jingle-blue']")
	private   WebElement signup;
	@FindBy(xpath = "//input[@id='name']")
	private   WebElement name;
	@FindBy(xpath = "//input[@class='ant-select-selection-search-input']")
	private   WebElement gender;
	@FindBy(xpath = "//input[@id='email']")
	private   WebElement email;
	@FindBy(xpath = "(//div[@class='ant-select-item-option-content'])[2]")
	private   WebElement genderValue;
	@FindBy(xpath = "//input[@id='phoneNumber']")
	private   WebElement phone;
	@FindBy(xpath = "//input[@id='password']")
	private   WebElement pass;
	@FindBy(xpath = "//input[@type='checkbox']")
	private   WebElement accept;
//	@FindBy(xpath = "//div[text()='Phone Number Already Exists']")
//	private   WebElement expectmsg;
	@FindBy(xpath = "//button[@type='submit']")
	private   WebElement submitbtn;
	@FindBy (xpath = "//input[@name='otpField01']")
	private   WebElement otp;
	@FindBy(xpath = "//button[@type='submit']")
	private   WebElement finishbutn;
	@FindBy (xpath = "//span[@class='dashboard-profile-name']")
	private   WebElement profileName;
	
	public SignUpPage(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);
	}

	public SignUpPage launchURL() {
		driver.get(TestProperties.getProperty("login.url"));
		return this;
	}

	@Test
	public SignUpPage signUp() throws InterruptedException {
		seleniumHelper.clickOnWebElement(signup);
		seleniumHelper.sendKeys(name, TestProperties.getProperty("signup.userName"));
		seleniumHelper.clickOnWebElement(gender);	
		seleniumHelper.clickOnWebElement(genderValue);
		seleniumHelper.sendKeys(email, TestProperties.getProperty("signup.email"));
		seleniumHelper.sendKeys(pass, TestProperties.getProperty("signup.password"));
		seleniumHelper.sendKeys(phone, TestProperties.getProperty("signup.enterPhone"));
		seleniumHelper.clickOnWebElement(accept);
		seleniumHelper.clickOnWebElement(submitbtn);
		seleniumHelper.sendKeys(otp, TestProperties.getProperty("signup.otp"));
		seleniumHelper.clickOnWebElement(finishbutn);
		Thread.sleep(1000);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(profileName), "SignUp successful");
		ReportUtil.addScreenShot(LogStatus.PASS, "SignUp Successful");
		return this;
		
		
	}
}	

