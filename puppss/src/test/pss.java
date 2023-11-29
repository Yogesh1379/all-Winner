package test;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class pss {
	@Test
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://demo.automationtesting.in/Windows.html");
		String Parent_ID = driver.getWindowHandle();
		Reporter.log(Parent_ID, true);
		
		driver.findElement(By.xpath("(//button[@class='btn btn-info'])[1]")).click();
		Set<String> child_ID = driver.getWindowHandles();
		for(String a:child_ID) 
		{
			Reporter.log(a, true);
			
			if(Parent_ID.equals(a)) {
				
			}
			else
			{
				driver.switchTo().window(a);
				driver.findElement(By.xpath("//a[@class='selenium-button selenium-ide text-uppercase font-weight-bold']")).click();
			}
		}
		
		
	//	driver.findElement(By.xpath("//a[@class='selenium-button selenium-ide text-uppercase font-weight-bold']")).click();
		//driver.quit();
		
	}

}
