package registerCases;
import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class regCase5 {
	
	@Test
	 public void differentPassword()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Rohit");
		driver.findElement(By.id("LastName")).sendKeys("Pawar");
		driver.findElement(By.id("Email")).sendKeys("Rohit1@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("pass12345");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("pass12346");
		driver.findElement(By.id("register-button")).click();
		String passverifyString = "The password and confirmation password do not match.";
		assertEquals(driver.findElement(By.xpath("//span[@for=\"ConfirmPassword\"]")).getText(), passverifyString);	
		
		driver.close();
		driver.quit();
	}
	
}
