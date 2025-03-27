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

//		ChromeOptions options = getChromeOptions();
		System.out.println("ChromeDriver path: " + System.getProperty("webdriver.chrome.driver"));
		WebDriver driver=new ChromeDriver(getChromeOptions());

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.name("username")).sendKeys("Admin");

		driver.findElement(By.name("password")).sendKeys("admin123");

		driver.findElement(By.tagName("button")).click();

		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

		driver.quit();
	}

	private static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless"); // CI requirement
		options.addArguments("--no-sandbox"); // Linux CI fix
		options.addArguments("--disable-dev-shm-usage"); // Shared memory fix
		options.addArguments("--disable-gpu"); // Headless fix
		options.addArguments("--remote-allow-origins=*"); // WebSocket fix
		// Avoid using any user data dir to prevent conflicts
		options.addArguments("--incognito"); // Use incognito mode to avoid profiles
		options.addArguments("--disable-extensions"); // Disable extensions
		options.addArguments("--disable-default-apps"); // Avoid default app loadin
		return options;
	}
}
