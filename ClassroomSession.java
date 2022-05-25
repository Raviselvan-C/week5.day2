package week5.day2;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassroomSession {
	
		public RemoteWebDriver driver;
	@Parameters({"URL","browser"})
	@BeforeMethod
	public void launchBrowser(String url,String browser) {
		WebDriverManager.chromedriver().setup();
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setBinary("E:\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
		
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		
	}
	
	@AfterMethod
	public void endBrowser() {
		driver.close();
		}
}
