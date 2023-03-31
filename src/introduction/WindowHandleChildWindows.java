package introduction;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleChildWindows {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedirver.exe");
		WebDriver driver = new ChromeDriver();
		
		String url = "https://rahulshettyacademy.com/loginpagePractise/#";
		driver.get(url);
		
		WebElement pageLink = driver.findElement(By.cssSelector(".blinkingText"));
		pageLink.click();
		
		Set <String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		WebElement textWithUserName = driver.findElement(By.cssSelector(".im-para.red"));
		String userName = getUserName(driver,textWithUserName);
		driver.switchTo().window(parentId);
		WebElement userNameField = driver.findElement(By.cssSelector("#username"));
		userNameField.sendKeys(userName);
		String pwd = driver.findElement(By.cssSelector("div.form-group p b:nth-child(2) i")).getText();
		WebElement pwdField = driver.findElement(By.cssSelector("#password"));
		pwdField.sendKeys(pwd);
		WebElement signInBtn = driver.findElement(By.cssSelector("#signInBtn"));
		signInBtn.click();
		
		
	}
	
	public static String getUserName(WebDriver driver , WebElement textWithUserName) {
		String wholeText = textWithUserName.getText();
		String [] brokenText = wholeText.split(" ");
		for (int i = 0; i<brokenText.length; i++) {
			if(brokenText[i].contains("@")&& brokenText[i].contains(".")) {
				String[] email= brokenText[i].split("@");
				for(int j=0; j<email.length; j++) {
					if(email[j].contains(".")) {
						String[] username =email[j].split("[.]");
						for (int k=0; k<username.length; k++) {
							if(!username[k].contains("[.]")) {
								return username[k];
							}
						}
					}
				}
			}
		}return null;
		
	}

}
