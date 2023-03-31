package introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://jqueryui.com/droppable/";
		driver.get(url);
		
		WebElement iFrame = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iFrame); //1.- you can locate the frame and pass it to the frame() as an element 
										//2.-driver.switchTo().frame()// you can pass the id or name to the frame() and it will locate it 
		List <WebElement> iframes = driver.findElements(By.tagName("iframe")); //3.- find all iframes on the page
										//driver.switchTo().frame(0);3.- list the int index of the desired frame 
		System.out.println(iframes.size());
		WebElement dragabbleIcon = driver.findElement(By.cssSelector(".ui-widget-content"));
		WebElement droppableArea = driver.findElement(By.cssSelector("#droppable"));
		
		Actions a = new Actions (driver);
		a.dragAndDrop(dragabbleIcon, droppableArea).perform();
		driver.switchTo().defaultContent(); // makes driver goes out of the iframe 
		
		

	}

}
