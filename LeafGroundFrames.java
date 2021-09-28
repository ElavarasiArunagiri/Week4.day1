package week4.day1.assignements;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundFrames {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/frame.html");
		//WebElement frame1 = driver.findElement(By.xpath("(//div[@id='wrapframe'])[1]/iframe"));
		driver.switchTo().frame(0);
		WebElement clickbutton = driver.findElement(By.id("Click"));
		File frame1button = clickbutton.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/LeafGroundFrame1ClickMe.png");
		FileUtils.copyFile(frame1button,dst);
		clickbutton.click();
		File frame1button1 = clickbutton.getScreenshotAs(OutputType.FILE);
		File dst1 = new File("./snaps/LeafGroundFrame1AfterClick.png");
		FileUtils.copyFile(frame1button1, dst1);
		driver.switchTo().defaultContent();
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of frames visible to main page: "+frames.size());
		
		
	}

}
