import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterFunctionality {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.cssSelector("#search-field")).sendKeys("Rice");
		//in veggies we are collecting element when filtered performed by the developer
		List<WebElement>veggies=driver.findElements(By.xpath("//tr/td[1]"));
		//in filtered list we are performing filter using our script
		List<WebElement>flterdlist=veggies.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		//if both are equals then filter functionality is working
		Assert.assertEquals(veggies.size(), flterdlist.size());
	}

}
