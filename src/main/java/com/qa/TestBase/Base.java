package com.qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.Utilities.BasicUtilities;

public class Base {

	public static WebDriver driver = null;
	public static Properties prop =  null;
	public FileInputStream ip = null;
	public String FILE_PATH = "/Users/vipan/eclipse-workspace/com.qa.FreeCRMDesignOne2021/src/"
			+ "main/java/com/qa/config/config.properties"; 
	
	public Base() throws Exception {
		ip = new FileInputStream(FILE_PATH);
		prop = new Properties();
		prop.load(ip);
	}
	
	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/vipan/Downloads/chromedriver 5");	
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(BasicUtilities.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(BasicUtilities.IMPLICIT_TIME_OUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
}
