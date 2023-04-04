package introduction;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamFilter {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver(); 
		
		String url ="https://rahulshettyacademy.com/seleniumPractise/#/offers";
		
		driver.get(url);
		
		WebElement searchField = driver.findElement(By.cssSelector("#search-field"));
		searchField.sendKeys("Rice");
		List<WebElement> veggies = driver.findElements(By.xpath("//tr //td [1]"));
		
		List <WebElement> filteredList = veggies.stream().filter(veggie-> veggie.getText().contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(veggies, filteredList);
		
		

	}

}
