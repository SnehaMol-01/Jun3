package com.frames;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Screenshot extends Utility {
public static WebDriver driver;
@Test
public void Browser() {
	try {
		
	
	driver=new ChromeDriver();
	 driver.get("https://www.facebook.com/");
	 WebElement element = driver.findElement(By.id("email"));
	 element.click();
	 //Thread.sleep(2000);
	 robot("keypress", "H");
	 robot("keyRelease","H");
	 robot("keypress", "E");
	 robot("keyRelease","E");
	
	
	 Screenshot("name", driver);
	
	 
	} catch (Exception e) {
		
	}
 


	 
	 
}

	

}
