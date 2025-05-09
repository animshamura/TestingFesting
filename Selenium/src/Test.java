import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
public class Test {
public static void main(String[] args) {

System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
// Initialize the WebDriver
WebDriver driver = new ChromeDriver();
try {
// Navigate to a test site
driver.get("https://demo.guru99.com/test/login.html");
// Get and print page title

// Find a single element (dummy selector used for illustration)
WebElement email = driver.findElement(By.name("email"));
email.sendKeys("shamuraanim7@gmail.com");
Thread.sleep(2000);

WebElement pass = driver.findElement(By.name("password"));
pass.sendKeys("1234");
Thread.sleep(3000);

WebElement button = driver.findElement(By.name("sign in"));
button.click();
Thread.sleep(2000);

} catch (Exception e) {
e.printStackTrace();
} finally {
// Quit the browser
driver.quit();
}
}
}