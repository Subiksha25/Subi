package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.basepage.BasePage;
import com.helper.SeleniumHelper;

public class PaymentMethodsPage extends BasePage {

	SeleniumHelper seleniumHelper;
	
	@FindBy(xpath = "//button[@class='new-method has-tooltip false svelte-1u727jy']/div/div/div[text()='Netbanking']")
	public WebElement netbankingButton;
	
//	@FindBy(xpath = "(//div[@id='form-netbanking']/div/div/div/div)[2]")
//	public WebElement hdfcNetBankingButton;
	
	@FindBy(xpath = "//div[@id='form-netbanking']/div/div/div/div/label[@for='bank-radio-HDFC']")
	public WebElement hdfcNetBankingButton;
	
	@FindBy(xpath = "//span[contains(text(), 'Pay')]/parent::div")
	public WebElement payButton;
	
	@FindBy(xpath = "//button[text()='Success']")
	public WebElement paymentSuccessButton;
	
	@FindBy(xpath = "//button[text()='Failure']")
	public WebElement paymentFailureButton;
	
	public PaymentMethodsPage(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);
		
	}

	public PaymentMethodsPage netBankingPayment() {
			driver.switchTo().frame(0);
			seleniumHelper.clickOnWebElement(netbankingButton);
			seleniumHelper.clickOnWebElement(hdfcNetBankingButton);
			seleniumHelper.clickOnWebElement(payButton);
			seleniumHelper.SwitchToWindow(1);
			seleniumHelper.waitForElement(paymentSuccessButton, 10);
			seleniumHelper.clickOnWebElement(paymentSuccessButton);
			seleniumHelper.switchToParentWindow();
			
		return this;
		
	}
}
