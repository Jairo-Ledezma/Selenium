package introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String url = "https://rahulshettyacademy.com/dropdownsPractise/";

		driver.get(url);
		driver.manage().window().maximize();

		WebElement checkbox1 = driver.findElement(By.cssSelector("input[id*='friendsandfamily']"));
		checkbox1.click();
		boolean isSelected = checkbox1.isSelected();
		Assert.assertTrue(isSelected); // assertion from testng library, this will stop the execution if the boolean
										// evaluates to false since it expects true

		WebElement checkbox2 = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"));
		checkbox2.click();
		isSelected = checkbox1.isSelected();
		boolean isSelected2 = checkbox2.isSelected();

		Thread.sleep(5000l);
		Assert.assertFalse(isSelected);// assertion from testng library, this will stop the execution if the boolean
										// evaluates to true since it expects false
		Assert.assertTrue(isSelected2);

		// checkbox count
		List<WebElement> checkBoxCount = driver.findElements(By.cssSelector("input[type='checkbox']")); // gets all the
																										// elements with
																										// type checkbox
																										// and input tag
																										// and puts them
																										// in a list
		int actualSize = checkBoxCount.size(); // returns an int value representing the number of elements on the list
		Assert.assertEquals(actualSize, 6); // asserts 2 integers first value is actual second value is expected
		driver.close(); // closes the browser

	}

}
