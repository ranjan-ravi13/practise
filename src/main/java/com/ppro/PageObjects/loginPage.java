package com.ppro.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class loginPage extends BasePage {
	

	@FindBy(xpath = "//input[@id='login_id']")
	public WebElement userName;
	
	@FindBy(xpath = "//button[@id='nextbtn']")
	public WebElement continueBtn;
	
	@FindBy(xpath = "//input[@id='password']")
	public WebElement password;
	
	@FindBy(xpath = "//button[@id='nextbtn']")
	public WebElement signIn;
	
	public AppPage doLogin(String username,String pass) throws InterruptedException {
		
	//	userName.sendKeys(username);
		Thread.sleep(3000);
		//continueBtn.click();
	//	userName.sendKeys(password);
		//signIn.click();
		
		type(userName, username, "Username textbox");
		click(continueBtn, "Sign in Button");
		Thread.sleep(3000);
		type(password, pass, "Password textbox");
		click(signIn, "Sign in Button");

		return (AppPage) openPage(AppPage.class);
		
		
	}
	
	
	public loginPage doLoginAsInvalidUser(String username, String pass) {

		type(userName, username, "Username textbox");
		click(continueBtn, "Sign in Button");
		type(password, pass, "Password textbox");
		click(signIn, "Sign in Button");

		return this;

	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(userName);
	}

}
