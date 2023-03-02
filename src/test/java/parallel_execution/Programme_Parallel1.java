package parallel_execution;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Programme_Parallel1 
{
	WebDriver driver;
	SoftAssert sa = new SoftAssert();
	@BeforeClass
	void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@Test(priority = 1)
	void login()
	{
		driver.get("http://localhost/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		
	}
	@Test(priority = 2)
	void title()
	{
		String exp_title = "actiTIME - Login";
		String act_title = driver.getTitle();
		System.out.println(act_title);
		
		sa.assertEquals(exp_title,act_title );
		sa.assertAll();
		
	}
	@AfterClass
	void closeapp()
	{
		driver.quit();
	}
	
	

}
