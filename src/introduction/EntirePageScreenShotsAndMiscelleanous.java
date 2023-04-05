package introduction;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EntirePageScreenShotsAndMiscelleanous {

	public static void main(String[] args) throws IOException {

		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Minimizing Window
		driver.manage().window().minimize();

		// Maximizing window

		driver.manage().window().maximize();

		// Deleting cookies

		driver.manage().deleteAllCookies();

		// Deleting some cookies by name
		// driver.manage().deleteCookieNamed("add cookie name here");

		// taking screenshots
		driver.get("https://www.google.com");

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src,
				new File("C:\\Users\\jairo\\Desktop\\new selenium\\Selenium\\Screenshots\\SSMiscelleanousClass.png"));

	}

}
