package introduction;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		// Explicit way targets specific elements to wait for an amount of time before
		// throwing an exception
		// scenarios in which loading time is lengthy Explicit way is used to run the
		// script
		// Note that it does not have an effect on every element or step of the script
		// as implicit wait do

		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String[] desiredProducts = { "Cucumber", "Brocolli", "Beetroot" }; // creates an array of items needed

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/"); // goes to the website
		Thread.sleep(3000);

		addItems(driver, desiredProducts);
		checkoutProcess(driver);

	}

	public static void addItems(WebDriver driver, String[] desiredProducts) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']")); // creates a list of
																									// strings with the
																									// name of the
																									// products, note
																									// that name of the
																									// products
																									// structure is name
																									// - 1Kg

		for (int i = 0; i < products.size(); i++) { // initiates a loop that traverses the list of products on the
													// website

			String[] productName = products.get(i).getText().split("-"); // accesses the product on index i and splits
																			// the name into an array ([0] name / [1]-
																			// /[2]Kg)
			String actualName = productName[0].trim(); // assigns the actual name of the product by getting the index
														// ([0] name ) and trims the blank space in the end

			List<String> itemsNeededList = Arrays.asList(desiredProducts);// for easier handling it converts the desired
																			// products array into an arrayList called
																			// itemsNeededList

			if (itemsNeededList.contains(actualName)) { // conditional testing the name of the product on the website
														// (already trimmed) is contained in the arrayList of items
														// needed
				j++;// increments the count so we can break the loop once all the items in the array
					// list are selected
					// driver.findElements(By.xpath("//div[@class='product-action'] //button[@type
					// ='button']")).get(i).click();

				driver.findElements(By.xpath("//div[@class='product-action'] /button")).get(i).click(); // accesses the
																										// specific
																										// webelement
																										// "add to cart
																										// button"
																										// (notice the
																										// get(i) so we
																										// click on the
																										// element that
																										// is being
																										// looped
																										// trough) and
																										// clicks on it

				if (j == itemsNeededList.size()) { // conditional to test that all the elements in the arraylist of
													// needed items are added based on the size of the arraylist
					break; // if the elements clicked matches the number of indexes in the array list
							// ofitems needed it breaks the loop to avoid additional looping
				}
			}
		}
	}

	public static void checkoutProcess(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));// explicit wait declaration, creates an
																			// object of WebDriverwait class that
																			// receives the driver and
																			// Duration.ofSeconds() parameters
		String promoCode = "rahulshettyacademy";
		WebElement bagIcon = driver.findElement(By.cssSelector("img[alt='Cart']"));
		WebElement checkoutButton = driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']"));
		bagIcon.click();
		checkoutButton.click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode"))); // w(instance of
																									// wait) .
																									// until(method of
																									// the instance)
																									// takes as
																									// parameter
																									// ExpectedConditions
																									// class that has
																									// many methods to
																									// wait
		WebElement promoCodeField = driver.findElement(By.cssSelector("input.promoCode"));
		promoCodeField.sendKeys(promoCode);
		WebElement promoBtn = driver.findElement(By.cssSelector(".promoBTn"));
		promoBtn.click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));// w(instance of wait)
																									// . until(method of
																									// the instance)
																									// takes as
																									// parameter
																									// ExpectedConditions
																									// class that has
																									// many methods to
																									// wait
		WebElement promoInfo = driver.findElement(By.cssSelector("span.promoInfo"));
		Assert.assertTrue(promoInfo.isDisplayed(), "Promo Info was not displayed");

	}

}
