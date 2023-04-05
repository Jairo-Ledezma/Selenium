package introduction;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingSecureSocketsLayerCertificates {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions(); // options class to confugure browser options
		options.setAcceptInsecureCerts(true); // setting options to accept insecure certificates
		// options.addExtensions(null) for adding extensions

		// setting proxy
		/*
		 * Proxy proxy = new Proxy(); proxy.setHttpProxy("ipadress:4444");
		 * options.setCapability("proxy", proxy);
		 */

		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options); // pass the options to the instance of the browser

		String url = "https://expired.badssl.com/";

		driver.get(url);

	}

}
