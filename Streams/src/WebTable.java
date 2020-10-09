import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//we are checking that whether the WebTable is sorted or not
		
		//click on column
		driver.findElement(By.xpath("//tr/th[1]/span[1]")).click();
		
		//capture all WebElement into list
		List<WebElement> elementlist=driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text of all elements in original list
		List<String> originialist=elementlist.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort the original list
		List<String> sortedList=originialist.stream().sorted().collect(Collectors.toList());
		
		//compare lists
		Assert.assertTrue(originialist.equals(sortedList));
		List<String>price;
		
		//find the price of any item (using pagination feature)
		do{
				List<WebElement> rows=driver.findElements(By.xpath("//tr/td[1]"));
				price = rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
				price.forEach(s->System.out.println(s));
				if(price.size()<1)
					driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}while(price.size()<1);
	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
