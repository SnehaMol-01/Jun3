package com.frames;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
//------browser------//
public class Utility {
	public static WebDriver driver;
	public static void initialization(String browserName,String url) {
		switch(browserName) {
		case "chrome":
		driver=new ChromeDriver();
		driver.get(url);
		break;
		case "Edge":
		driver=new EdgeDriver();
		driver.get(url);
		break;
		default:
			  System.out.println("Driver is not initilaised");
		
		}
	}
	//--------actions--------//
	public static void actions(WebElement element,String method,WebElement target) {
		Actions move=new Actions(driver);
		switch(method) {
		
	        case "MoveToElement":
			move.moveToElement(element).perform();
			break;
	        case "doubleclick":
	        	move.doubleClick(element).perform();
	            break;
	        case"rightclick":
	        	move.contextClick(element).perform();
	        	 break;
	        case"click":
	        	move.click(element).perform();
	        	break;
	        case"draganddrop":
	        	move.dragAndDrop(element, target);
	        	break;
	        default:
	        	System.out.println("method is not found");
		}}
	//-----------Java executor--------//
	public static void executor(String element,WebElement ref ) {
		JavascriptExecutor element1 =(JavascriptExecutor)driver;
      switch(element)	{
	   case "scroll down":
		   element1.executeScript(("arguments[0], scrollIntoView(true);"),ref);
		   break;
	   case "scrollup":
		   element1.executeScript("arguments[0], scrollIntoView(false);", ref);
		   break;
	   case "scroll to top":
	      element1.executeScript("window.scroll(0,0)");
	      break;
	   case "scroll to end page":
		   element1.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		   break;
	   case "click":
		   element1.executeScript("arguments[0].click();", ref);
		   break;
	   case "refresh":
		   element1.executeScript("history.go(0)");
		   break;
		   default:
			   System.out.println("method is not found");
		   }}
		//-------robot class--------//
		public static void robot(String keys ,String keyChar ) throws AWTException {
		Robot r=new Robot();
		keys=keys.toLowerCase();
		int keycode=KeyEvent.getExtendedKeyCodeForChar(keyChar.charAt(0));
		switch(keys) {
		case"keypress":
			r.keyPress(keycode);
			break;
		case"keyrelease":
			r.keyRelease(keycode);
		break;
		default:
			System.out.println("no keys are there");
		}}
		//---------WebDriver commands-----//
		public static void method(WebDriver driver,String meth,int x, int y) {
		switch(meth) {
		case "min":
			driver.manage().window().minimize();
			break;
		case "max":
			driver.manage().window().maximize();
			break;
		case "dimension":
			Dimension d =new Dimension(x, y);
			driver.manage().window().setSize(d);
			break;
		case "position":
			Point p=new Point(x,y);
			driver.manage().window().setPosition(p);
			break;
			default:
				System.out.println("no such method");
			
		}}
	
	//----screenshot------//
  public static void Screenshot(String name ,WebDriver driver) {
	  try {
	     File ScreenshotAs=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     File destination=new File("C:\\Users\\Admin\\Downloads\\"+name+".png");
	     FileUtils.copyFile(ScreenshotAs, destination);
		  
		  
	  }catch (Exception e) {
		   e.printStackTrace();
	  }} 
  //--------select-------//
  public static void select(String method ,WebElement ref,String value,int index) {
	  switch(method) {
	  case "selectbyvalue":
		  Select a=new Select(ref);
		  a.selectByValue(value);
		  break;
	  case "selectbyindex":
		  Select b=new Select(ref);
		  b.selectByIndex(index);
		  break;
	  case "selectbytext":
		  Select c=new Select(ref);
		  c.selectByVisibleText(value);
		  break;
	  default:
		  System.out.println("no such element");
		  
	  }
	  
  }
  //-------Alert-------//
  public static void alert(String method ,String keystosend) {
	  switch(method) {
	  case"accept":
		  driver.switchTo().alert().accept();
		  break;
	  case"dismiss":
		  driver.switchTo().alert().dismiss();
		  break;
	  case"sendkeys":
		  driver.switchTo().alert().sendKeys(keystosend);
		  break;
		  default:
			  System.out.println("there is no method");
	  }}
  //-------frames-------//
    public static void frames(String method ,int index,String name,WebElement ref) {
	  switch(method) {
	  case"index":
		  driver.switchTo().frame(index);
		  break;
	  case"name":
		  driver.switchTo().frame(name);
		  break;
	  case"ref":
		  driver.switchTo().frame(ref);
		  break;
	  }}
    public static void nestedframes(String method,int index) {
    	switch(method) {
    	case"frame":
    		driver.switchTo().frame(index);
    		break;
    	case"parent":
    		driver.switchTo().parentFrame();
    		break;
    	case"default":
    		driver.switchTo().defaultContent();
    		break;
    		
    	}}
     //-------waits-------//i
    public static void wait(Long seconds) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    	
    }
    
    //--------findelement-------//
    public static WebElement element(String method ,String locator) {
    	WebElement element;
    	switch(method) {
    	case "id":
    	element=driver.findElement(By.id(locator));
    	break;
    	case "classname":
    		element=driver.findElement(By.className(locator));
    		break;
    	case "name":
    		element=driver.findElement(By.name(locator));
    		break;
    	case "xpath":
    		element=driver.findElement(By.xpath(locator));
    		break;
    	default:
    		return null;
    	}
    	return element;
    	}
   //-------find elements-------//
    	public static List<WebElement>  listElements (String method1,String locator1) {
    		List<WebElement> elements;
    		switch(method1) {
    		case "id":
    			elements=driver.findElements(By.id(locator1));
    			break;
    		case"classname":
    			elements=driver.findElements(By.className(locator1));
    			break;
    		case"name":
    			elements=driver.findElements(By.name(locator1));
    			break;
    		case"xpath":
    			elements=driver.findElements(By.xpath(locator1));
    			break;
    		default:
    			return null;
    		
    		}
    		return elements;
    	}
    		
    	
    	
    	
    	
    }
		  
		  
	  
	
	 
	  
	  
	  
  
	  
	  
	  
  
	  
  
			
			
		
	
	

	
