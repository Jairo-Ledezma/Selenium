package introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String url = "https://rahulshettyacademy.com/dropdownsPractise/";
		driver.get(url);

		// dropdown with select tag the class Select only works if the dropdown tag is
		// <select>
		// create an object of the Select class and as parameter insert the web element
		// with the dropdown
		WebElement sDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); // static dropdown
																									// element in
																									// sDropDown
																									// WebElement
																									// variable
		Select dropDown = new Select(sDropDown); // instance of Select class with static dropdown element as parameter
		dropDown.selectByIndex(3); // selects by index take into consideration that indexes start with 0
		String option1 = dropDown.getFirstSelectedOption().getText(); // returns the text of the web element (because of
																		// the getText method) so it has to be wrapped
																		// in a string variable
		WebElement option4 = dropDown.getFirstSelectedOption(); // like this it will only return the web element
		dropDown.selectByValue("INR"); // selects by value
		String option2 = dropDown.getFirstSelectedOption().getText(); // returns the text of the web element (because of
																		// the getText method) so it has to be wrapped
																		// in a string variable
		dropDown.selectByVisibleText("AED");// selects by visible text
		String option3 = dropDown.getFirstSelectedOption().getText(); // returns the text of the web element (because of
																		// the getText method) so it has to be wrapped
																		// in a string variable
		System.out.println(option1); // Prints the text of option1
		System.out.println(option2);// Prints the text of option2
		System.out.println(option3);// Prints the text of option3

		// Note there are additional methods on the Select class

	}

}
