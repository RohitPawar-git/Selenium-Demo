package registerCases;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class regCase1 {

	@Test
	public void Test1 () {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demowebshop.tricentis.com/");
		//Form submission
		driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Rohit");
		driver.findElement(By.id("LastName")).sendKeys("Pawar");
		driver.findElement(By.id("Email")).sendKeys(generateMail());
		driver.findElement(By.id("Password")).sendKeys("Admin@123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Admin@123");
		driver.findElement(By.id("register-button")).click();
		//Verification
		String actualresultString ="Your registration completed";
		assertEquals(driver.findElement(By.className("result")).getText(), actualresultString);		
		driver.findElement(By.xpath("//input[@class=\"button-1 register-continue-button\"]")).click();
		String actulString = "Log out";
		Assert.assertEquals(driver.findElement(By.className("ico-logout")).getText(),actulString);
		
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
		return "Rohitpawar"+ s + "@gmail.com";
	}

}
