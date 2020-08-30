package com.ppro.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ppro.PageObjects.HomePage;
import com.ppro.PageObjects.loginPage;
import com.ppro.Setup.BaseTest;


public class TestCase2 extends BaseTest {
	
	private String browser;
	private HomePage homePage;
	loginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		//openBrowser(browser);
		//homePage = new HomePage().open("https://www.zoho.com/");
	}
	
	
	@Test
	//public void doLoginTest(String UserName,String Password, String browser) throws InterruptedException {
		
	public void doLoginTest() throws InterruptedException	{
	
		System.out.println(" Read Test configuration file browser : " + browser);
		//openBrowser(browser);
		openBrowser();
		System.out.println("Browser opened");
		homePage = new HomePage().open("https://www.zoho.com/");
		loginPage = homePage.gotoLogin();
		loginPage.doLogin("crsh4ravi.13@gmail.com","ranjanravi");
		//logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
		//Assert.fail("Failing the login test");
		
		
		
	
		
//		HomePage homePage = new HomePage(getWebDriver());
//		loginPage loginPage = homePage.gotoLogin();
//		loginPage.doLogin("crsh4ravi.13@gmail.com", "ranjanravi");
		
		
//		getWebDriver().findElement(By.xpath("//a[text()='Login']")).click();
//		getWebDriver().findElement(By.xpath("//input[@id='login_id']")).sendKeys(UserName);
//		getWebDriver().findElement(By.xpath("//button[@id='nextbtn']")).click();
//		Thread.sleep(3000);
//		getWebDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
//		getWebDriver().findElement(By.xpath("//button[@id='nextbtn']")).click();
//		
		closeBrowser();
		
	
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[1][3];
		
		data[0][0] = "crsh4ravi@gmail.com";
		data[0][1] = "ranjanravi";
		data[0][2] = "chrome";

		
		return data;
	}

}
