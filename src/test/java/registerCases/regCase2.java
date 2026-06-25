package registerCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class regCase2 {
	
	@Test
	@BeforeTest
	public void firstNameValidation() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demowebshop.tricentis.com/");
		//Form submission
		driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("User");
		driver.findElement(By.id("Email")).sendKeys(generateMail());
		driver.findElement(By.id("Password")).sendKeys("Test@1234");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Test@1234");
		driver.findElement(By.id("register-button")).click();
		//Verification
		Thread.sleep(1000);
		driver.close();
		driver.quit();
	}
		// Every Time new mail will be get generated.
	   static String generateMail()
	{
		Date date=new Date();
		String s = date.toString();
		s=s.replaceAll(":","");
		s=s.replaceAll(" ","");
		return "blank_fn"+ s + "@demo.com";
	}
	

}
