package introduction;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class GettingHeightAndWidthOfAnElement {

	public static void main(String[] args) {
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
		
		int height = nameField.getRect().getHeight();
		int width = nameField.getRect().getWidth();
		System.out.println("height is: " + height + " width is: " + width);

	}

}
