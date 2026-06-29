	package loginLogout;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class login2 {
	@Test
	public void wrongPassword(){
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://demowebshop.tricentis.com/");
			driver.findElement(By.className("ico-login")).click();
			
			assertTrue(driver.getCurrentUrl().contains("/login"));
			
			driver.findElement(By.id("Email")).sendKeys("admin123200@yourstore.com");
			driver.findElement(By.id("Password")).sendKeys("WrongPass	999");
			driver.findElement(By.xpath("//input[@type=\"submit\" and @class=\"button-1 login-button\"]")).click();
			String validationMessageString =driver.findElement(By.xpath("//div[@class=\"validation-summary-errors\"]")).getText();
			assertTrue(validationMessageString.contains("Login was unsuccessful. Please correct the errors "));
			driver.close();
			driver.quit();
	}
}
