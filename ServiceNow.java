package week4.day1.assignements;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.ArrayList;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://dev76307.service-now.com");
		WebElement frame = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("NKOh34ySerfY");
		driver.findElement(By.id("sysverb_login")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		WebElement frame1 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
		Set<String> winSet = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winSet);
		//System.out.println("No. of windows: "+winList.size());
		driver.switchTo().window(winList.get(1));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[3]/a")).click();
		driver.switchTo().window(winList.get(0));
		Thread.sleep(500);
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("automation testing");
		String inciNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("The new incident number: "+inciNumber);
		driver.findElement(By.xpath("//button[@class='form_action_button header  action_context btn btn-default']")).click();
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(inciNumber, Keys.ENTER);
		String inciNumber1 = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[3]/a")).getText();
		System.out.println("The incident number in results: "+inciNumber1);
		if(inciNumber.equals(inciNumber1))
			System.out.println("The incident creation is successful.");
		else
			System.out.println("The incident creation failed.");

	}

}
