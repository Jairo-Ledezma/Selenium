package introduction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaStreamsWithSeleniumAndPagination {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jairo\\Desktop\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		String url ="https://rahulshettyacademy.com/seleniumPractise/#/offers";
		driver.get(url);
		
		//click on colum 
		WebElement sort = driver.findElement(By.xpath("//tr//th[1]"));
		sort.click();
		//capture All WebElements into a list
		List <WebElement> firstRow = driver.findElements(By.xpath("//tr//td[1]"));
		
		//capture text of all webElements into new (original) list 
		List<String> originalList = firstRow.stream().map(s->s.getText()).collect(Collectors.toList());
		//sort the original list 
		List <String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		//compare original vs sorted
		Assert.assertTrue(sortedList.equals(originalList));
		
		//getting the price of a product 
		//scan the name column with the getText -> rice -> print price of the rice
		List <String> price;
		
		do {
			List <WebElement> nextRows = driver.findElements(By.xpath("//tr//td[1]"));
			price = nextRows.stream().filter(s-> s.getText().contains("Rice")).map(s->getVeggiePrice(s)).collect(Collectors.toList());
			price.forEach(a->System.out.println(a));
			if(price.size()<1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		}while(price.size()<1);
			
		
		
		

	}

	private static String getVeggiePrice(WebElement s) {
		
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
