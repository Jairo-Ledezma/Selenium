package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendars {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String url = "https://rahulshettyacademy.com/dropdownsPractise/";
		driver.get(url);
		
		WebElement roundTripRadioButton = driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']"));
		
		
		WebElement oneWayRadioButton = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
		//roundTripRadioButton.click();
		//oneWayRadioButton.click();
		
		
		// handling calendars
		// you need to select destination first so it gets enabled lines 28-36
		
		WebElement dropdownArrow = driver.findElement(By.xpath("(//span[@class='red-arrow-btn'])[1]"));
		dropdownArrow.click();
		Thread.sleep(2000L);
		WebElement departureCity = driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")); 
		departureCity.click();
		Thread.sleep(1000);
		WebElement destCity = driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"));
		destCity.click();
		Thread.sleep(2000);
		WebElement currentDay = driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")); // locator for current day
		currentDay.click();
		WebElement returnCalendar = driver.findElement(By.name("ctl00$mainContent$view_date2"));
		WebElement returnCalendarVisibility = driver.findElement(By.cssSelector("#Div1"));
		String style = returnCalendarVisibility.getAttribute("style");
		System.out.println(style);
		roundTripRadioButton.click();
		style = returnCalendarVisibility.getAttribute("style");
		System.out.println(style);
		driver.close();
		
		
		
		
		
		
		
	}

}
