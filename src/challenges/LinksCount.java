package challenges;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LinksCount {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String url="https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);
		
		List <WebElement> links= driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		
		List<WebElement> footerLinks = driver.findElements(By.xpath("//div[@id='gf-BIG'] //a"));
		
		System.out.println(footerLinks.size());
		
		WebElement firstColumnDriver = driver.findElement(By.cssSelector("#gf-BIG td:first-child"));
		
		List <WebElement> firstColumnLinks = firstColumnDriver.findElements(By.tagName("a"));
		System.out.println(firstColumnLinks.size());
		
		for (int i =1; i<firstColumnLinks.size(); i++) {
			Actions a = new Actions(driver);
			
			String clickOnLink = Keys.chord(Keys.CONTROL , Keys.ENTER);
			firstColumnLinks.get(i).sendKeys(clickOnLink);	
		}
		
		Set<String> windows = driver.getWindowHandles();
		Iterator <String> it = windows.iterator();
		
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		
		

	}

}
