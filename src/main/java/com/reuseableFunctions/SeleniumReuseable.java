package com.reuseableFunctions;

import java.io.File;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.baseClass.Library;

public class SeleniumReuseable extends Library {
	
	public SeleniumReuseable(WebDriver driver) {
		this.driver = driver;
	}
	
	//Enter the text
	public void EnterValue(WebElement element, String Text) {
		
		try {
			element.sendKeys(Text);
		}
		catch (Exception e) {
			System.out.println("No Such element Exception");
		}
	}
	
	//Clicks the element
	public void click(WebElement element) {
		
		try {
			element.click();
		}
		catch (Exception e) {
			System.out.println();
		}
	}
	
	//get the title
	public void getTitle() {
		
		try {
			System.out.print(driver.getTitle());
		}
		catch (Exception e) {
			System.out.print("Could not get the title");
		}
	}
	
	//taking screenshot of the test case
	public void screenshot(String path) {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		try {
		   FileUtils.copyFile(source, new File(path));
		}
		catch (Exception e) {
			System.out.println("Screenshot not found");
		}
	}

}
