package introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollOnPageJavaScriptExecutor {

	public static void main(String[] args) {

		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String url = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scroll(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		List<WebElement> values = driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[4]"));
		int sum = 0;

		for (int i = 0; i < values.size(); i++) {
			int value = Integer.parseInt(values.get(i).getText());
			sum += value;

		}

		WebElement text = driver.findElement(By.cssSelector(".totalAmount"));
		String[] values2 = text.getText().split(" ");

		for (int i = 0; i < values2.length; i++) {

			try {
				int number = Integer.parseInt(values2[i]);
				if (sum == number) {
					Assert.assertEquals(sum, number);
				}
			} catch (Exception e) {
				continue;
			}
		}

	}

}
