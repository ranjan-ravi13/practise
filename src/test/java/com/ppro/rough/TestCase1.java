package com.ppro.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ppro.PageObjects.HomePage;
import com.ppro.PageObjects.loginPage;

public class TestCase1 extends BaseTest {
	
		
	@Test(dataProvider="getData")
	public void doLogin(String UserName,String Password, String browser) throws InterruptedException {
		
		openBrowser(browser);			
		
		HomePage homePage = new HomePage(getWebDriver());
		loginPage loginPage = homePage.gotoLogin();
		loginPage.doLogin("crsh4ravi.13@gmail.com", "ranjanravi");
		
//		getWebDriver().findElement(By.xpath("//a[text()='Login']")).click();
//		getWebDriver().findElement(By.xpath("//input[@id='login_id']")).sendKeys(UserName);
//		getWebDriver().findElement(By.xpath("//button[@id='nextbtn']")).click();
//		Thread.sleep(3000);
//		getWebDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
//		getWebDriver().findElement(By.xpath("//button[@id='nextbtn']")).click();
		
		closeBrowser();
		
	
		
	}
	
	@DataProvider(parallel=false)
	public Object[][] getData(){
		
		Object[][] data = new Object[2][3];
		
		data[0][0] = "crsh4ravi.13@gmail.com";
		data[0][1] = "ranjanravi";
		data[0][2] = "chrome";
				
		data[1][0] = "r4ravi@gmail.com";
		data[1][1] = "ranjavi";
		data[1][2] = "firefox";
		
		return data;
	}

}
