//changing admin name from settings
package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class case3 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        
        driver.get("https://okobiscuit-admin.vercel.app/login");
        Thread.sleep(1000);
        
        // Login process
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("superAdmin@gmail.com");
        driver.findElement(By.id("password")).sendKeys("superAdmin00@11");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
 
        // Wait for a few seconds after login
        Thread.sleep(3000);
        
        
		driver.get("https://okobiscuit-admin.vercel.app/superAdmin/settings");
		
		Thread.sleep(2000);
		
		WebElement textField = driver.findElement(By.xpath("//input[@placeholder='Write here...']"));
		textField.sendKeys(Keys.CONTROL + "a"); // Select all text
		textField.sendKeys(Keys.DELETE);       // Delete the selected text
		textField.sendKeys("OKO COOKIES");     // Enter the new text
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		String acting_url = driver.getCurrentUrl();
		String desired_url = "https://okobiscuit-admin.vercel.app/superAdmin/settings";
		
		if(acting_url.equals(desired_url))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
//		driver.close();
//		driver.quit();
	}
}