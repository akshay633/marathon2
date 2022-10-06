package marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
        ch.addArguments("--disable-notifications");
        ChromeDriver driver=new ChromeDriver(ch);
        driver.manage().window().maximize();
        driver.get("https://www.redbus.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        WebElement from = driver.findElement(By.xpath("//input[@id='src']"));
        from.click();
        from.sendKeys("Chennai");
        driver.findElement(By.xpath("//li[@class='selected']")).click();
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@class='selected']")).click();
        
        driver.findElement(By.xpath("//label[text()='Date']")).click();
        driver.findElement(By.xpath("//td[@class='wd day']")).click();
        Thread.sleep(5000);
                       
        driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
        Thread.sleep(5000);
       // WebElement click = driver.findElement(By.xpath("//i[@class='icon icon-close']"));
        //click.click();
        Thread.sleep(3000);
        
        String bus = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
        System.out.println("Buses found :"+ bus);
        
        Thread.sleep(3000);
        WebElement sleeper = driver.findElement(By.xpath("//label[@for='bt_SLEEPER'][1]"));
        driver.executeScript("arguments[0].click();", sleeper);
        
        
        String busname = driver.findElement(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[2]")).getText();
        System.out.println("Bus name :"+ busname);
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[text()='View Seats'])[2]")).click();
        
        File source = driver.getScreenshotAs(OutputType.FILE);
        File dest= new File("./snaps2/screenshot.png");
        FileUtils.copyFile(source, dest);
        
        
        
       
        
        
	}

}
