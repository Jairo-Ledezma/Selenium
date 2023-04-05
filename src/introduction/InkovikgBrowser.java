package introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InkovikgBrowser {

	public static void main(String[] args) {
		// Chrome Launch
		// 1.- indicate where the chromedriver is
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		// 2.- invoke browser
		WebDriver driver = new ChromeDriver();

		// Firefox Launch
		// 1.- indicate where the firefox driver is
		// System.setProperty("webdriver.gecko.driver",
		// "C:\\Users\\jairo\\Desktop\\WebDrivers\\geckodriver.exe");
		// 2.- invoke browser
		// WebDriver driver = new FirefoxDriver();

		// Edge Launch
		// 1.- indicate where the edge driver is
		// System.setProperty("webdriver.edge.driver",
		// "C:\\Users\\jairo\\Desktop\\WebDrivers\\msedgedriver.exe");
		// 2.- invoke browser
		// WebDriver driver = new EdgeDriver();

		driver.get("https://rahulshettyacademy.com");
		String tittle = driver.getTitle();
		System.out.println(tittle);
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		driver.close();// closes current page
		driver.quit(); // closes entire browser

	}

}
