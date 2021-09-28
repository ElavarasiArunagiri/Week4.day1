package week4.day1.assignements;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class CherCherFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Testing");
		
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame2");
		WebElement animalsSelect = driver.findElement(By.id("animals"));
		Select animals = new Select(animalsSelect);
		animals.selectByVisibleText("Avatar");
		
		driver.switchTo().defaultContent();
		//There are 3 frames, 1 and 3 are nested frames. Finding the no. of frames visible to the main page.
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("The number of frames visible to main page: " +frames.size());
		
		

	}

}
