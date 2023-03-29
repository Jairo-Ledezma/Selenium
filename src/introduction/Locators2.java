package introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		String name = "Jairo";
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String password = getPassword(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // implicit wait
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		WebElement usernameField = driver.findElement(By.id("inputUsername")); // find element by ID
		usernameField.sendKeys(name);
		WebElement pwdField = driver.findElement(By.name("inputPassword")); // find element by name
		pwdField.sendKeys(password);
		WebElement signInButton = driver.findElement(By.className("signInBtn")); // find element by class name
		signInButton.click();
		Thread.sleep(2000);
		String loginMessage = driver.findElement(By.tagName("p")).getText();
		Assert.assertEquals(loginMessage, "You are successfully logged in."); // Assert comes from testng library dependency
		String greeting = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		Assert.assertEquals(greeting, "Hello " + name +",");// Assert comes from testng library dependency
		WebElement logOutButton= driver.findElement(By.xpath("//button[text()='Log Out']")); // xpath found by text of the button 
		logOutButton.click();
		driver.close();
		

	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		WebElement forgotPassword = driver.findElement(By.linkText("Forgot your password?"));
		forgotPassword.click();
		Thread.sleep(1000);
		WebElement resetLoginButton = driver.findElement(By.cssSelector("button[class='reset-pwd-btn']"));
		resetLoginButton.click();
		String message = driver.findElement(By.cssSelector("form p")).getText();
		String[] list = message.split("'");
		message = list[1];
		return message;
	}

}
