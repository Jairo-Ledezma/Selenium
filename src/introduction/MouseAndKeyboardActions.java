package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseAndKeyboardActions {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://www.amazon.com.mx/";
		driver.get(url);
		driver.manage().window().maximize();
		WebElement navIcon = driver.findElement(By.cssSelector("[id=\"nav-link-accountList\"]")); // locates the element we will hover on 
		
		Actions a = new Actions(driver);// instance of the action class, it receives the driver as parameter 
		
		
		a.moveToElement(navIcon).perform(); // the instance of the action class (a) using the method moveToElement() which received the element we will hover on 
		
		WebElement searchBar = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		
		a.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys("test").doubleClick().perform(); // moves to element, clicks on it, keyDown() receives the key to be pressed and hold sendKeys() receives the text
		a.moveToElement(navIcon).contextClick().perform();
		
		
		
		
		


	}

}
