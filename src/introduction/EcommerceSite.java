package introduction;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EcommerceSite {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		int j = 0;

		String[] desiredProducts = { "Cucumber", "Brocolli", "Beetroot" }; // creates an array of items needed

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/"); // goes to the website
		Thread.sleep(3000); // waits for the products on the website to load

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
																			// the name into an array ([0] name / [1]- /
																			// [2]Kg)
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
				// driver.findElements(By.xpath("//div[@class='product-action'] //button[@type =
				// 'button']")).get(i).click();
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
					break; // if the elements clicked matches the number of indexes in the array list of
							// items needed it breaks the loop to avoid additional looping
				}
			}
		}

	}

}
