import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Booking {
	
	
	
	
	@Test
	public  void TicketBooking() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 Actions act=new Actions(driver);
		 //driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
		 driver.get("https://www.mercurytravels.co.in");
		 Thread.sleep(5000);
		 WebElement customer=driver.findElement(By.linkText("Customer Login"));
		 act.moveToElement(customer).build().perform();
		 Thread.sleep(5000);
		 WebElement userlogin=driver.findElement(By.linkText("User Login"));
		 act.moveToElement(userlogin).click().build().perform();
		 Thread.sleep(5000);
		 driver.findElement(By.id("sign_user_email")).sendKeys("admintest@test.com");
		 driver.findElement(By.id("sign_user_password")).sendKeys("test");
		 
		 driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary modal-btn ajax-submit']")).click();
		 Thread.sleep(2000);
		 
		 WebElement international=driver.findElement(By.linkText("International Holidays"));
		 act.moveToElement(international).click().build().perform();
		 driver.findElement(By.id("holiday_category_d")).sendKeys("canada");
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//li[@class='ui-menu-item']//a[1]")).click();
		
		 WebElement selectduration=driver.findElement(By.id("duration_d"));
		 Select opt=new Select(selectduration);
		 opt.selectByIndex(4);
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//div[@class='searchBtncntr']//button[@type='submit']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("14/12/2022");
		WebElement themes= driver.findElement(By.id("themes"));
		Select opt1=new Select(themes);
		opt1.selectByIndex(4);
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		 Thread.sleep(2000);
		 String expect="Canada Tour Packages";
		 String actual=driver.findElement(By.xpath("//h1[text()='Canada  Tour Packages']")).getText();
		 Assert.assertEquals(actual, expect);
		 Thread.sleep(2000);
		 driver.close();
	}

}
