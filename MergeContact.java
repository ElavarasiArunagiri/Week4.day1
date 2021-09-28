package week4.day1.assignements;

import java.time.Duration;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();
		Set<String> webSet = driver.getWindowHandles();
		List<String> winName = new ArrayList<String>(webSet);
		//System.out.println(winName);
		driver.switchTo().window(winName.get(1));
		driver.manage().window().maximize();
		WebElement fromContact = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		System.out.println("1st contact: "+fromContact.getText());
		fromContact.click();
		driver.switchTo().window(winName.get(0));
		
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();
		Set<String> webSet2 = driver.getWindowHandles();
		List<String> winName2 = new ArrayList<String>(webSet2);
		//System.out.println(winName2);
		driver.switchTo().window(winName2.get(1));
		driver.manage().window().maximize();
		WebElement toContact = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]"));
		System.out.println("2nd contact: "+toContact.getText());
		toContact.click();
		driver.switchTo().window(winName2.get(0));
		driver.findElement(By.linkText("Merge")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		if(driver.getTitle().contains("View Contact"))
			System.out.println("The contact merged and displayed in View Contact page.");
		else
			System.out.println("Check out the merge contact is not successful.");
		
		
		
		
		
		

	}

}
