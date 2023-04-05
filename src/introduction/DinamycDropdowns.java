package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DinamycDropdowns {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String url = "https://rahulshettyacademy.com/dropdownsPractise/";
		driver.get(url);
		WebElement dropdownArrow = driver.findElement(By.xpath("(//span[@class='red-arrow-btn'])[1]"));
		dropdownArrow.click();
		Thread.sleep(2000L);

		// one way with indexed xpaths

		// WebElement departureCity = driver.findElement(By.xpath("//a[@value='BLR']"));
		// departureCity.click();
		// Thread.sleep(1000);
		// WebElement destCity = driver.findElement(By.xpath("(//a[@value='MAA'])[2]"));
		// destCity.click();

		// anther way using parent child xpath locator
		WebElement departureCity = driver
				.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']"));
		// this
		// xpath
		// contains
		// the
		// parent
		// xpath
		// /div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']
		// a
		// blank
		// space
		// and
		// then
		// the
		// child
		// xpath
		// //a[@value='BLR']
		// this
		// will
		// limit
		// the
		// child
		// xpath
		// search
		// to
		// only
		// be
		// searchable
		// within
		// the
		// parent
		// xpath

		departureCity.click();
		Thread.sleep(1000);
		WebElement destCity = driver.findElement(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"));
		destCity.click();

	}

}
