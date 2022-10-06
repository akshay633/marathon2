package marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
        ChromeOptions ch = new ChromeOptions();
        ch.addArguments("--disable-notifications");
        ChromeDriver driver=new ChromeDriver(ch);
        driver.manage().window().maximize();
        driver.get("https://in.bookmyshow.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search for your city']"));
        search.click();
        search.sendKeys("Hyderabad");
        driver.findElement(By.xpath("//li[@class='sc-dTLGrV eqBsHh']")).click();
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Url :"+ currentUrl);
        
        WebElement search1 = driver.findElement(By.xpath("//span[contains(text(),'Search for Movies, Events, Plays,')]"));
        search1.click();
        WebElement search2 = driver.findElement(By.xpath("//input[@placeholder='Search for Movies, Events, Plays, Sports and Activities']"));
        search2.click();
        Thread.sleep(2000);
        search2.sendKeys("Godfather");
        
        driver.findElement(By.xpath("//strong[text()='Godfather']")).click();
        driver.findElement(By.xpath("//span[text()='Book tickets']")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//span[text()='2D']")).click();
       // Alert alert = driver.switchTo().alert();
        //alert.dismiss();
        
       // Thread.sleep(2000);
        //driver.findElement(By.xpath("//button[@class='No thanks']")).click();
        
        Thread.sleep(2000);
        String theater = driver.findElement(By.xpath("//a[@class='__venue-name']")).getText();
        System.out.println("Name of theater"+ theater);
        
        driver.findElement(By.xpath("//div[@class='venue-info-text']")).click();
        Thread.sleep(2000);
        
        String parking = driver.findElement(By.xpath("(//div[@class='facility-text'])[4]")).getText();
        
        
        if(parking.contains(parking)) {
        	System.out.println("Parking facility available");
        }else {
        	System.out.println("Parking facility not available");
        }
        driver.findElement(By.xpath("//div[@class='cross-container']")).click();
        
        driver.findElement(By.xpath("//div[@class='showtime-pill-container']/a")).click();
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//div[text()='Accept']")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//li[text()='1']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'				Select Seats')]")).click();
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("(//a[@class='_available'])[2]")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//a[@class='bar-btn _primary']")).click();
        Thread.sleep(2000);
        
        String total = driver.findElement(By.xpath("//span[@class='__sub-total']")).getText();
        System.out.println("Subtotal :"+total);
        
        File source = driver.getScreenshotAs(OutputType.FILE);
        File dest= new File("./snaps/screenshot.png");
        FileUtils.copyFile(source, dest);
        
        
        
        
	}

}
