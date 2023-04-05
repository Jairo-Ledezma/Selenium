package introduction;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakingPartialScreenShotOfOnlyAWebElement {

	public static void main(String[] args) throws IOException {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String url = "https://rahulshettyacademy.com/angularpractice/";
		String secondUrl = "https://rahulshettyacademy.com/";

		driver.get(url);

		driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		String parentId = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);
		driver.get(secondUrl);

		WebElement coursesBlock = driver.findElement(By.cssSelector("#courses-block"));
		List<WebElement> coursesNames = coursesBlock.findElements(By.cssSelector("[id='courses-block'] h2 a"));
		String firstCourse = coursesNames.get(0).getText();
		driver.switchTo().window(parentId);
		WebElement nameField = driver.findElement(By.cssSelector("[name='name']"));
		nameField.sendKeys(firstCourse);

		File ss = nameField.getScreenshotAs(OutputType.FILE); // gets the element and converts it to a File class object
		FileUtils.copyFile(ss, new File("C:\\Users\\jairo\\Desktop\\new selenium\\Selenium\\Screenshots\\ElementSS.png"));// FileUtils class copyFile method receives the File object and
																														 // creates an actual file that will receive the name of it, it
																														// stores the photo in the root of the project if no address is given 
																													   //an address has been given in this case (for no address just type the ss name.png)
		driver.quit();	

	}

}
