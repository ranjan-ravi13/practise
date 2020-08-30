package com.ppro.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ppro.Setup.DriverManager;



public class HomePage extends BasePage {
	
	
	@FindBy(xpath = "//a[text()='Login']")
	public WebElement login;
	
	
	public HomePage open(String url) {
		
		System.out.println("Page Opened");
		DriverManager.getDriver().get(url);
		
		
		return (HomePage) openPage(HomePage.class);
	}
	
	public loginPage gotoLogin(){
		System.out.println("inside go to login");
		click(login, "Login Link");
		return (loginPage) openPage(loginPage.class);
			
	}


	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(login);
	}
	


}
