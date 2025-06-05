hpackage com.frames;

import java.awt.Dimension;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Framesutil extends Utility{
	public static WebDriver driver;
	@Test
	public void action() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		Actions a=new Actions(driver);
		WebElement category=driver.findElement(By.id("category"));
		a.moveToElement(category).perform();
		WebElement makeup = driver.findElement(By.xpath("(//a[text()='makeup'])[2]"));
		a.doubleClick(makeup).perform();
		//Thread.sleep(3000);
		WebElement product = driver.findElement(By.xpath("//div[@class='outline-wrapper'][1]"));
		executor("scroll down", product);
		executor("scrollup", product);
		executor("scroll to top",null);
		executor("scroll to end page", null);
		executor("click", product);
		executor("refresh",null);
//         method(driver, "max", null, null);
//		method(driver,"min", null, null);
//	hello	
		
	
		
	
		
		
	}

}
