package introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // implicit wait
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		WebElement usernameField = driver.findElement(By.id("inputUsername")); // find element by ID
		usernameField.sendKeys("Jairo");
		WebElement pwdField = driver.findElement(By.name("inputPassword")); // find element by name
		pwdField.sendKeys("hello12345");
		WebElement signInButton = driver.findElement(By.className("signInBtn")); // find element by class name
		signInButton.click();

		String errorSignText = driver.findElement(By.cssSelector("p.error")).getText(); // find element by css
																						// locator
		/*
		 * Css Selector-
		 * 
		 * Class name -> tagname.classname -> Button.signInBtn -> .error
		 * 
		 * Id -> tagname#id -> input#inputUsername
		 * 
		 * Tagname[attribute=’value’]
		 * 
		 * <input type="text" placeholder="Username” value=" ">
		 * 
		 * Input [placeholder=’ Username’]
		 * 
		 * //Tagname[@attribute=’value’]:nth-child(index). - Child items Parenttagname
		 * childtagname input[type*='pass'] – CSS tagname
		 * 
		 */

		WebElement forgotPassword = driver.findElement(By.linkText("Forgot your password?")); // find element by
																								// linkText (make sure
																								// element is tag "a"
																								// (anker) and copy the
																								// text of it)
		forgotPassword.click();
		WebElement nameField = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		nameField.sendKeys("Jairo");

		/*
		 * Xpath –
		 * 
		 * //Tagname[@attribute=’value’] //input[@placeholder=’ Username’’]
		 * 
		 * <input type="text" placeholder="Name"> //input[@placeholder=’ Name’]
		 * 
		 * //Tagname[@attribute=’value’][index] //parentTagname/childTagname
		 * //button[contains(@class,'submit')]. – Regular expression //tagname
		 * //header/div/button[1]/following-sibling::button[1]
		 * //header/div/button[1]/parent::div
		 */
		WebElement emailField = driver.findElement(By.cssSelector("input[placeholder='Email']")); // find element by css
																									// with customized
																									// query
		emailField.sendKeys("test@test.com");

		emailField.clear(); // deletes the input given on line 69
		emailField = driver.findElement(By.xpath("//input[@type='text'][2]")); // find element by xpath indexed (there
																				// are many type= text elements so [2]
																				// is the index of the one you want )
																				// not encouraged as web pages may
																				// change
																				// and the locator would be lost
		emailField.sendKeys("test@test.com");

		WebElement phoneNumberField = driver.findElement(By.xpath("//form/input[3]")); // find element by xpath
																						// traversing from parent to
																						// child //form(parent) /
																						// input(child tag)[3] indexed
																						// tag
		phoneNumberField.sendKeys("1234567890");

		WebElement resetLoginButton = driver.findElement(By.cssSelector("button[class='reset-pwd-btn']"));
		resetLoginButton.click();

		String message = driver.findElement(By.cssSelector("form p")).getText(); //

		// splitting the text by the "'" sign
		String[] list = message.split("'");
		message = list[1]; // assigning only the password to the message

		WebElement goToLogInButton = driver.findElement(By.cssSelector("button[class='go-to-login-btn']"));
		goToLogInButton.click();

		usernameField.sendKeys("Jairo");
		pwdField.sendKeys(message);

		Thread.sleep(1000);
		signInButton.click();
		driver.close();

	}

}
