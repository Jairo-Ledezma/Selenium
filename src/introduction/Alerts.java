package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String url = "https://rahulshettyacademy.com/AutomationPractice/";

		driver.get(url);
		WebElement nameField = driver.findElement(By.id("name"));
		nameField.sendKeys("Jairo");

		WebElement alertButton = driver.findElement(By.id("alertbtn"));
		alertButton.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		alertButton.click();
		// driver.switchTo().alert().dismiss(); use this method for close button in
		// alert

		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		driver.switchTo().alert().dismiss();

		// driver.switchTo().alert().sendKeys("text"); if the alert requires text use
		// this method

		driver.close();

	}

}
