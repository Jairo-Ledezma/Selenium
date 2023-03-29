package introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowBrowserActivities {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); // will maximize the screen 
		driver.get("https://google.com"); // will wait until all components are loaded before proceeding 
		driver.navigate().to("https://rahulshettyacademy.com"); // continues as soon as something is loaded 
		driver.navigate().back(); //will navigate back (like clicking on the back arrow on the browser)
		driver.navigate().forward(); // will click on the forward arrow on the browser
		
		
		

	}

}
