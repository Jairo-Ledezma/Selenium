package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://rahulshettyacademy.com/dropdownsPractise/";
		driver.get(url);

		WebElement clickableDropdown = driver.findElement(By.xpath("//div[@class='paxinfo']"));
		clickableDropdown.click();
		Thread.sleep(2000L);
		WebElement plusAdultBtn = driver.findElement(By.id("hrefIncAdt"));
		WebElement plusChildBtn = driver.findElement(By.id("hrefIncChd"));
		WebElement plusInfantBtn = driver.findElement(By.id("hrefIncInf"));
		WebElement doneBtn = driver.findElement(By.id("btnclosepaxoption"));
		
		
		for (int i = 1; i <= 3; i++) {

			plusAdultBtn.click();
			plusChildBtn.click();
			plusInfantBtn.click();
		}
		doneBtn.click();

	}

}
