package loginLogout;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class login6 {

	@Test
	public void forgotPasswordLink()
	{

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.xpath("//a[text()='Forgot password?']")).click();
		
		assertTrue(driver.getCurrentUrl().endsWith("/passwordrecovery"));
		assertTrue(driver.findElement(By.xpath("//input[@type=\"submit\" and @value=\"Recover\"]")).isDisplayed());
		driver.close();
		driver.quit();
	}
}
