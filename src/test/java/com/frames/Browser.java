package com.frames;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;


   
public class Browser extends Utility {
	
	
	 @Test
public void browser() {
		 
		 initialization("chrome","https://letcode.in/courses"); 
		 element("xpath", "");
		 actions(element, method, target);
		 actions

	

	}
	
}
	