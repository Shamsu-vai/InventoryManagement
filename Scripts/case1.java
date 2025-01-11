//User Login with valid credentials
package day1;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
 
public class case1 {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://okobiscuit-admin.vercel.app/login");
 
        // for better understanding add some time
        Thread.sleep(1000);
 
        driver.findElement(By.id("email")).sendKeys("junkyoggy@gmail.com");
        driver.findElement(By.id("password")).sendKeys("12341234");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
 
        // Explicit wait for the URL to change
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://okobiscuit-admin.vercel.app/seller/dashboard"));
 
        String current = driver.getCurrentUrl();
        String desired = "https://okobiscuit-admin.vercel.app/seller/dashboard";
 
        if (current.equals(desired))
            System.out.println("Pass");
        else
            System.out.println("Fail");
 
        // Close the driver
        //driver.quit();
    }
}
 