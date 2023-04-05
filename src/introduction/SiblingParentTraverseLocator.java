package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SiblingParentTraverseLocator {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Sibling - child - parent traverse

		String url = "https://rahulshettyacademy.com/AutomationPractice/";

		driver.get(url);

		WebElement loginButton = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")); // relative
																														// xpath
																														// reaching
																														// loging
																														// button
																														// traversing
																														// parent
																														// to
																														// child
																														// to
																														// sibling
																														// //header(grandparent)
																														// /
																														// div
																														// (parent)/button[1](child)/following-sibling::(command
																														// to
																														// traverse
																														// to
																														// sibling)
																														// button[1](first
																														// sibling
																														// after
																														// the
																														// actual
																														// first
																														// child
																														// listed)

		System.out.println(loginButton.getText());

		WebElement loginButtonParent = driver.findElement(By.xpath("//header/div/button[1]/parent::div")); // traversing
																											// child to
																											// parent
																											// check the
																											// above
																											// comment
																											// for guide
		System.out.println(loginButtonParent.getText());
		driver.close();

	}

}
