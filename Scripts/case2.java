//Adding a New User via Admin Portal

package day1;
 
import java.awt.datatransfer.StringSelection;
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class case2 {
 
    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeOptions for remote debugging or other configurations
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
 
        // Navigate to the login page
        driver.get("https://okobiscuit-admin.vercel.app/login");
 
        // Adding some wait time for better understanding
        Thread.sleep(1000);
 
        // Login process
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("superAdmin@gmail.com");
        driver.findElement(By.id("password")).sendKeys("superAdmin00@11");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
 
        // Wait for a few seconds after login
        Thread.sleep(3000);
 
        // Navigate to add user page
        driver.get("https://okobiscuit-admin.vercel.app/superAdmin/add-user");
        
        // Fill out the "name" and other fields
        driver.findElement(By.id("name")).sendKeys("shahbagi");
 
        // Interact with the custom "role" dropdown
        WebElement dropdown = driver.findElement(By.id("role"));
        
        // Click the dropdown to open it
        dropdown.click();
        
        // Select the "Seller" option from the dropdown
        driver.findElement(By.xpath("//div[contains(@class, 'ant-select-item-option-content') and text()='Seller']")).click();
 
        // Fill out the email and password fields
        driver.findElement(By.id("email")).sendKeys("shahbagi@gmail.com");
        driver.findElement(By.id("password")).sendKeys("12345678");
 
        // Upload image using file input
        StringSelection filePath = new StringSelection("C://Users//shams//Downloads//image (4).png");
        WebElement urlInput = driver.findElement(By.cssSelector("input[type='file']"));
        urlInput.sendKeys("C://Users//hasan//Downloads//ara ara.jpg");
 
        // Wait a bit for the image upload
        Thread.sleep(1000);
 
        // Submit the form by clicking the primary button
        driver.findElement(By.cssSelector("button.ant-btn-primary")).click();
 
        // Submit the form again (if needed)
        driver.findElement(By.cssSelector("button[type='submit']")).click();
 
        // Wait for the next page to load (explicit wait)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://okobiscuit-admin.vercel.app/superAdmin/add-user"));
 
        // Check the current URL to verify success
        String current = driver.getCurrentUrl();
        String desired = "https://okobiscuit-admin.vercel.app/superAdmin/add-user";
 
        if (current.equals(desired)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
 
        // Close the browser session
//        driver.quit();
    }
}