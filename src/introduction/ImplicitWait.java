package introduction;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ImplicitWait {

	public static void main(String[] args) throws InterruptedException {
		// When you declare an implicit wait, you tell the driver to wait n number of
		// second before throwing an exception
		// advantages:
		// It is declared globally, for the entire test case which means that script
		// will wait for n seconds before throwing an exception
		// every time an exception is supposed to be threw, as an example if you enter a
		// form and click search, without the implicit wait
		// the script would continue execution and fail right away since the website has
		// not loaded the elements required on the script
		// therefore it will most likely throw a no such element exception, if an
		// implicit wait is declared the script will wait for
		// the number of seconds the implicit wait has before throwing the exception,
		// giving time for the website to be loaded and
		// the execution to continue, note this is dynamic, which means that if you give
		// 5 seconds to the implicit wait and it will
		// wait for those 5 seconds before throwing the exception, however, if at second
		// 3 the page is fully loaded then the script does
		// not wait 5 seconds but it continues right away, the following script is
		// constantly evaluated and if it can continue it will

		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // implicit time declaration
		

		String[] desiredProducts = { "Cucumber", "Brocolli", "Beetroot" }; // creates an array of items needed

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/"); // goes to the website
		
		
		addItems(driver, desiredProducts);
		checkoutProcess(driver);
		
		

	}

	public static void addItems(WebDriver driver, String[] desiredProducts) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']")); // creates a list of strings with the name of the products, note that name of the products
																								 // structure is name - 1Kg

		for (int i = 0; i < products.size(); i++) { // initiates a loop that traverses the list of products on the  website

			String[] productName = products.get(i).getText().split("-"); // accesses the product on index i and splits the name into an array ([0] name / [1]- /[2]Kg)
			String actualName = productName[0].trim(); // assigns the actual name of the product by getting the index ([0] name ) and trims the blank space in the end

			List<String> itemsNeededList = Arrays.asList(desiredProducts);// for easier handling it converts the desired products array into an arrayList called itemsNeededList

			if (itemsNeededList.contains(actualName)) { // conditional testing the name of the product on the website (already trimmed) is contained in the arrayList of items needed
				j++;// increments the count so we can break the loop once all the items in the array list are selected driver.findElements(By.xpath("//div[@class='product-action'] //button[@type ='button']")).get(i).click();
				
				driver.findElements(By.xpath("//div[@class='product-action'] /button")).get(i).click(); // accesses the specific webelement "add to cart button" (notice the get(i) so we click on the element that
																										// is being looped trough) and clicks on it

				if (j == itemsNeededList.size()) { // conditional to test that all the elements in the arraylist of needed items are added based on the size of the arraylist
					break; // if the elements clicked matches the number of indexes in the array list ofitems needed it breaks the loop to avoid additional looping
				}
			}
		}
	}
	
	public static void checkoutProcess(WebDriver driver ) {
		String promoCode = "rahulshettyacademy";
		WebElement bagIcon = driver.findElement(By.cssSelector("img[alt='Cart']"));
		WebElement checkoutButton = driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']"));
		bagIcon.click();
		checkoutButton.click();
		WebElement promoCodeField = driver.findElement(By.cssSelector("input.promoCode"));
		promoCodeField.sendKeys(promoCode);
		WebElement promoBtn = driver.findElement(By.cssSelector(".promoBTn"));
		promoBtn.click();
		WebElement promoInfo = driver.findElement(By.cssSelector("span.promoInfo"));
		Assert.assertTrue(promoInfo.isDisplayed(), "Promo Info was not displayed");
			
		
		
	}

}
