package introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdowns {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://rahulshettyacademy.com/dropdownsPractise/";
		driver.get(url);
		WebElement autoSuggestField = driver.findElement(By.xpath("//input[@placeholder='Type to Select']")); // locates the autosuggestive field
		autoSuggestField.sendKeys("me");
		Thread.sleep(3000);
		List<WebElement> suggestions = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a")); // this css
																											// selector
																											// is very
																											// important,
																											// it
																											// locates
																											// the
																											// suggestions
																											// list
																											// li[class='ui-menu-item']
																											// and then
																											// traverses
																											// to its
																											// child tag
																											// a
		/* regular for loop
		 * for (int i = 0; i < suggestions.size(); i++) { if
		 * (suggestions.get(i).getText().equals("United Kingdom (UK)")) {
		 * suggestions.get(i).click();
		 * break; } }
		 */
		
		//enhanced for loop
		for(WebElement suggestion : suggestions) {
			if(suggestion.getText().equals("Mexico")) {
				suggestion.click();
				break;
			}
		}

	}

}
