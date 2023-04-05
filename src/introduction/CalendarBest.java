package introduction;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarBest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		String url = "https://www.despegar.com.mx/";
		driver.get(url);

		WebElement cookies = driver.findElement(By.cssSelector(".lgpd-banner--button.eva-3-btn.-white.-md"));
		cookies.click();

		WebElement loginClose = driver
				.findElement(By.cssSelector(".login-incentive--close.shifu-3-icon-close.-eva-3-mr-md"));
		loginClose.click();

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement departure = driver.findElement(By.xpath("//input[@placeholder='Entrada']"));
		w.until(ExpectedConditions.elementToBeClickable(departure)).click();
		departure.click();

		chooseDates(driver, "enero", 2024, 25, "JUlIo", 2023, 31);
		// chooseReturnDate(driver, "JUlIo" , 2023 , 14);

	}

	public static void chooseDates(WebDriver driver, String leavingMonth, int leavingYear, int leavingDay,
			String returningMonth, int returningYear, int returningDay) {
		String desiredDay = String.valueOf(leavingDay);
		String desiredYear = String.valueOf(leavingYear);
		WebElement yearTag = driver.findElement(By.cssSelector(".sbox5-monthgrid-title-year"));
		WebElement monthTag = driver.findElement(By.cssSelector(".sbox5-monthgrid-title-month"));
		WebElement rightArrow = driver.findElement(By.cssSelector(".calendar-arrow-right"));
		List<WebElement> days = driver.findElements(By.xpath("//div[@class = 'sbox5-monthgrid-datenumber-number']"));

		while (!(yearTag.getText()).equalsIgnoreCase(desiredYear)) {
			rightArrow.click();
		}

		while (!(monthTag.getText()).equalsIgnoreCase(leavingMonth)) {
			rightArrow.click();
		}

		for (int i = 0; i < days.size(); i++) {
			String current = days.get(i).getText();
			if (current.equals(desiredDay)) {
				days.get(i).click();
				break;
			}
		}
		desiredDay = String.valueOf(returningDay);
		desiredYear = String.valueOf(returningYear);

		while (!(yearTag.getText()).equalsIgnoreCase(desiredYear)) {

			if (yearTag.getText().equalsIgnoreCase(desiredYear)) {
				break;
			} else {
				rightArrow.click();
			}
		}

		while (!(monthTag.getText()).equalsIgnoreCase(returningMonth)) {
			if (monthTag.getText().equalsIgnoreCase(returningMonth)) {
				break;
			} else {
				rightArrow.click();
			}
		}

		for (int i = 0; i < days.size(); i++) {
			String current = days.get(i).getText();
			if (current.equals(desiredDay)) {
				days.get(i).click();
				break;
			}
		}

	}

	/*
	 * public static void chooseReturnDate(WebDriver driver , String returningMonth
	 * , int returningYear, int returningDay ) { String desiredDay =
	 * String.valueOf(returningDay); String desiredYear =
	 * String.valueOf(returningYear); WebElement yearTag =
	 * driver.findElement(By.cssSelector(".sbox5-monthgrid-title-year")); WebElement
	 * monthTag =
	 * driver.findElement(By.cssSelector(".sbox5-monthgrid-title-month"));
	 * WebElement rightArrow =
	 * driver.findElement(By.cssSelector(".calendar-arrow-right")); List
	 * <WebElement> days = driver.findElements(By.
	 * xpath("//div[@class = 'sbox5-monthgrid-datenumber-number']"));
	 * 
	 * 
	 * while(!(yearTag.getText()).equalsIgnoreCase(desiredYear)) {
	 * 
	 * if(yearTag.getText().equalsIgnoreCase(desiredYear)) { break; }else {
	 * rightArrow.click(); } }
	 * 
	 * while(!(monthTag.getText()).equalsIgnoreCase(returningMonth)) {
	 * if(monthTag.getText().equalsIgnoreCase(returningMonth)) { break; }else {
	 * rightArrow.click(); } }
	 * 
	 * 
	 * 
	 * for (int i = 0; i<days.size(); i++) { String current = days.get(i).getText();
	 * if(current.equals(desiredDay)) { days.get(i).click(); break; } } }
	 */

}
