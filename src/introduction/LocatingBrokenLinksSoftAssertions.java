package introduction;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class LocatingBrokenLinksSoftAssertions {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String url = "https://rahulshettyacademy.com/AutomationPractice/";

		driver.get(url);

		List<WebElement> links = driver.findElements(By.cssSelector("#gf-BIG a"));
		SoftAssert a = new SoftAssert();

		for (int i = 0; i < links.size(); i++) {
			String urlLink = links.get(i).getAttribute("href");
			String text = links.get(i).getText();
			HttpURLConnection conn = (HttpURLConnection) new URL(urlLink).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			System.out.println(urlLink + " returned a " + responseCode);
			a.assertTrue(responseCode < 400, "The link with Text " + text + " is broken with code " + responseCode);

		}
		a.assertAll();

	}

}
