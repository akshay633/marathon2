package marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
        //ChromeOptions ch = new ChromeOptions();
        //ch.addArguments("--disable-notifications");
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        search.click();
        search.sendKeys("bags");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()=' for boys']")).click();
        
        String text = driver.findElement(By.xpath("//span[text()='1-48 of over 30,000 results for']")).getText();
        String[] split2 = text.split(" ");
        System.out.println("Total number"+ split2[3]);
        
        driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[4]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Generic']")).click();
        
        String text2 = driver.findElement(By.xpath("//span[text()='1-48 of over 5,000 results for']")).getText();
        String[] split = text2.split(" ");
        System.out.println(split[3]);
        
        if(split2.equals(split)) {
        	System.out.println("Not reduced");
        }else {
        	System.out.println("Reduced");
        }
        driver.findElement(By.xpath("//span[text()='Featured']")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//a[@id='s-result-sort-select_4']")).click();
       
     driver.findElement(By.xpath("//span[text()='21 L Latest Trends Laptop Backpack Bag Light Weight Stylish for Boys and Girls (Black)']")).click();
      
      Set<String> window1 = driver.getWindowHandles();
      ArrayList<String> list1= new ArrayList<String>(window1);
      driver.switchTo().window(list1.get(1));
      
      Thread.sleep(2000);
      String Bagname = driver.findElement(By.xpath("//h1[@id='title']")).getText();
      System.out.println("Bagname"+ Bagname);
      
      String price = driver.findElement(By.xpath("//span[text()='399']")).getText();
      System.out.println("Discounted price :"+ price);
      
      File screenshot = driver.getScreenshotAs(OutputType.FILE);
      File dest =new File("./snaps/screenshot.png");
      FileUtils.copyFile(screenshot, dest);
      
	}

}
