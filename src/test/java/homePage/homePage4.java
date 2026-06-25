package homePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class homePage4 {
	
	@Test
	public void verifylinks()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		
		assertTrue(driver.findElement(By.className("ico-register")).isDisplayed());
		String registerString ="Register";
		assertEquals(driver.findElement(By.className("ico-register")).getText(), registerString);
		
		assertTrue(driver.findElement(By.className("ico-login")).isDisplayed());
		String logString ="Log in";
		assertEquals(driver.findElement(By.className("ico-login")).getText(), logString);
		
		assertTrue(driver.findElement(By.className("cart-label")).isDisplayed());
		String shopcartString= "Shopping cart";
		assertEquals(driver.findElement(By.className("cart-label")).getText(), shopcartString);
		String cartqant="(0)";
		assertEquals(driver.findElement(By.className("cart-qty")).getText(),cartqant);
			
		assertEquals(driver.findElement(By.className("cart-label")).getText(),"Shopping cart");
		assertEquals(driver.findElement(By.className("wishlist-qty")).getText(), "(0)");
		
		
		driver.close();
		driver.quit();
	}

}
