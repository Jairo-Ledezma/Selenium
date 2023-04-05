package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.time.Duration;

public class RelativeLocators {

	public static void main(String[] args) {

		// NOTE: FOR THEM TO WORK A STATIC PACKAGE NEEDS TO BE MANUALLY IMPORTED import
		// static org.openqa.selenium.support.locators.RelativeLocator.*;

		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String url = "https://rahulshettyacademy.com/angularpractice/";

		driver.get(url);

		// RELATIVE LOCATOR ABOVE
		WebElement nameField = driver.findElement(By.cssSelector("[name='name']")); // gets the element below the
																					// locator we need
		WebElement aboveLocator = driver.findElement(with(By.tagName("label")).above(nameField)); // to be able to use
																									// this methods a
																									// static package
																									// needs to be
																									// imported
		// import static org.openqa.selenium.support.locators.RelativeLocator.*;
		System.out.println(aboveLocator.getText());

		// RELATIVE LOCATOR BELOW
		// do note that in this case the calendar for dob input is a flex input element
		// and relative locators cant find them so it skips to the next input element
		// available
		WebElement dobText = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		WebElement dobInputField = driver.findElement(with(By.tagName("input")).below(dobText));
		dobInputField.click();

		// RELATIVE LOCATOR TO RIGHT OF
		WebElement checkBox = driver.findElement(By.cssSelector("#exampleCheck1"));
		WebElement text = driver.findElement(with(By.tagName("label")).toRightOf(checkBox));
		System.out.println(text.getText());

		// RELATIVE LOCATOR TO LEFT OF
		WebElement employedText = driver.findElement(By.cssSelector("[for='inlineRadio2']"));
		WebElement employedCheckBox = driver.findElement(with(By.tagName("input")).toLeftOf(employedText));
		employedCheckBox.click();

	}

}
