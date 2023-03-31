package introduction;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitExample {

	public static void main(String[] args) throws InterruptedException {
		//Fluent way helps to monitor the Dom and looks for an element in specified intervals of time 
		// this goes on until the time runs out or the element is found the difference with 
		// fluent wait is that methods have to be written by us 
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String url = "https://the-internet.herokuapp.com/dynamic_loading/1";
		driver.get(url);
		
		WebElement startBtn = driver.findElement(By.xpath("//div[@id='start'] /button"));
		startBtn.click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)// creates an instance of wait interface with FluentWaitClass as well as additional methods
				.withTimeout(Duration.ofSeconds(30L))			// this method is to select the global waiting amount
			       .pollingEvery(Duration.ofSeconds(3L))		// this method selects how often will the dom be evaluated to test if element is present
			       .ignoring(NoSuchElementException.class); 	// this method ignores the exception class added to it 
		
		  WebElement foo = wait.until(new Function<WebDriver, WebElement>() { // a variable "foo" that points to a web element that will be returned 
			    
			  public WebElement apply(WebDriver driver) { // a method that simply receives a driver and returns a web element
			       WebElement hWoSt =  driver.findElement(By.cssSelector("[id='finish'] h4")); // elelemnt to be returned 
			       if (hWoSt.isDisplayed()) { // condition testing if element is visible (elements can be in the dom in invisible mode)
			       return hWoSt; // if it is visible it returns the element
			       }else {
			    	   return null; // if it is not it returns null, since the method has to return a web element this method will get executed every polling time 
			       }
			     }
			  
			   });
		  
		  System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed());
		
		

				
		
		
		
	}

}
