package com.ppro.Setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;

import com.ppro.Setup.DriverFactory;
import com.ppro.Setup.DriverManager;


public class BaseTest {

	private WebDriver driver;
	private Properties config = new Properties();
	private FileInputStream fis;
	public boolean grid = false;
	private String defaultUserName;
	private String defaultPassword;
	private String browser;
	
	

	public String getBrowser() {
		return browser;
	}




	public void setBrowser(String browser) {
		this.browser = browser;
	}




	public String getDefaultUserName() {
		return defaultUserName;
	}




	public void setDefaultUserName(String defaultUserName) {
		this.defaultUserName = defaultUserName;
	}




	public String getDefaultPassword() {
		return defaultPassword;
	}




	public void setDefaultPassword(String defaultPassword) {
		this.defaultPassword = defaultPassword;
	}



	@BeforeSuite
	public void setUpFramework() {

		// configureLogging();
		DriverFactory.setGridPath("http://localhost:4444/wd/hub");
		DriverFactory.setConfigPropertyFilePath(
				System.getProperty("user.dir") + "//src//test//resources//properties//Config.properties");

		DriverFactory.setChromeDriverExePath(
				System.getProperty("user.dir") + "//src//test//resources//executables//chromedriver.exe");
		DriverFactory.setGeckoDriverExePath(
				System.getProperty("user.dir") + "//src//test//resources//executables//geckodriver.exe");

		/*
		 * Initialize properties
		 * 
		 */
		try {
			fis = new FileInputStream(DriverFactory.getConfigPropertyFilePath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			// log.info("Config properties file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void openBrowser() {
		setBrowser(config.getProperty("browser"));
		
		System.out.println(config.getProperty("parallelOnGrid"));
		System.out.println(" Read configuration file browser : " + config.getProperty("browser"));
		grid = Boolean.parseBoolean(config.getProperty("parallelOnGrid"));
		
		DriverFactory.setRemote(grid);
		
		if (DriverFactory.isRemote()) {
			
			DesiredCapabilities cap = null;

			if (browser.equals("firefox")) {

				cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.ANY);

			} else if (browser.equals("chrome")) {

				cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.ANY);
			}
			
			try {
				driver = new RemoteWebDriver(new URL(DriverFactory.getGridPath()), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		} else

			if (browser.equals("chrome")) {
				System.out.println("Launching : " + browser);
				System.setProperty("webdriver.chrome.driver",
						DriverFactory.getChromeDriverExePath());
				driver = new ChromeDriver();
			} else if (browser.equals("firefox")) {
				System.out.println("Launching : " + browser);
				System.setProperty("webdriver.gecko.driver",
						DriverFactory.getGeckoDriverExePath());
				driver = new FirefoxDriver();

			}
		
		DriverManager.setWebDriver(driver);
		//log.info("Driver Initialized !!!");
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		setDefaultUserName(config.getProperty("defaultUserName"));
		setDefaultPassword(config.getProperty("defaultPassword"));
		

	}
	
	public void closeBrowser() {

		DriverManager.getDriver().quit();
		//log.info("Test Execution Completed !!!");
	}

//	private Properties Config = new Properties();
//	private FileInputStream fis;
//	public boolean grid=false;
//	private RemoteWebDriver driver;
//	public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
//	
//	public WebDriver getWebDriver() {
//		
//		return dr.get();
//	}
//	
//	public void setWebDriver(RemoteWebDriver driver) {
//		dr.set(driver);
//	}
//	
//	public void openBrowser(String browser) {
//		
////		if (browser.equals("chrome")) {
////			System.out.println("Launching : 1 " + browser);
////			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//executables//chromedriver.exe");
////			driver = new ChromeDriver();
////			
////		} else if (browser.equals("firefox")) {
////			System.out.println("Launching : 2" + browser);
////			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//test//resources//executables//geckodriver.exe");
////			driver = new FirefoxDriver();
////		}
//		
//		DesiredCapabilities cap=null;
//		
//		if (browser.equals("firefox")) {
//			
//			cap = DesiredCapabilities.firefox();
//			cap.setBrowserName("firefox");
//			cap.setPlatform(Platform.ANY);
//		} else if (browser.equals("chrome")) {
//			System.out.println("Launching 3 ");
//			cap = DesiredCapabilities.chrome();
//			cap.setBrowserName("chrome");
//			cap.setPlatform(Platform.ANY);
//			
//		}
//		
//		try {
//			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			
//		
//		setWebDriver(driver);
//		getWebDriver().manage().window().maximize();
//		getWebDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		getWebDriver().get("https://www.zoho.com");
//		
//	}
//	
//	public void closeBrowser() {
//		getWebDriver().quit();
//	}

}
