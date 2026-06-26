package loginLogout;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class login1 {

	@Test
	 public void loginwithAllcredintials(){
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.className("ico-login")).click();
		
		assertTrue(driver.getCurrentUrl().contains("/login"));
		
		driver.findElement(By.id("Email")).sendKeys("admin123200@yourstore.com");
		driver.findElement(By.id("Password")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@type=\"submit\" and @class=\"button-1 login-button\"]")).click();
		
		assertTrue(driver.getCurrentUrl().contentEquals("https://demowebshop.tricentis.com/"));
		assertTrue(driver.findElement(By.className("ico-logout")).isDisplayed());
		assertEquals(driver.findElement(By.className("account")).getText(),"admin123200@yourstore.com");
		driver.close();
		driver.quit();
	}
}
