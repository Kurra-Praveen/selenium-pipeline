package web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


public class LoginTest {

	@Test
	public void LoginApp(){
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless"); // Required for GitHub Actions
		options.addArguments("--no-sandbox"); // Avoid sandboxing issues on Linux
		options.addArguments("--disable-dev-shm-usage"); // Prevent shared memory issues
		options.addArguments("--disable-gpu"); // Disable GPU in headless mode
		options.addArguments("--remote-allow-origins=*"); // Fix WebSocket issues in newer Selenium
		// Explicitly set a temporary user data directory (optional, but resolves the error)
		options.addArguments("--user-data-dir=/tmp/chrome-user-data-" + System.currentTimeMillis());

		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.name("username")).sendKeys("Admin");

		driver.findElement(By.name("password")).sendKeys("admin123");

		driver.findElement(By.tagName("button")).click();

		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

		driver.quit();
	}
}
