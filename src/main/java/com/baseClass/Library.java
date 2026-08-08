package com.baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Library {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public void launchApplication() throws IOException {
		FileInputStream input = new FileInputStream("/flipkart_EndToEnd_project/src/test/resources/Properties/config.Property");
		prop = new Properties();
		prop.load(input);
		try {
			if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
			}
			else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(prop.getProperty("url"));
				
			
		}
		catch (Exception e){
			System.out.println("browser cann't be launched");
		}
		
	}
	public void teardown() {
		driver.close();
	}

}
