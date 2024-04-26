package com.example;


import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest 
{
    WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }
    @BeforeMethod
    public void openpage(){
        driver.get("https://economictimes.indiatimes.com/?from=mdr");
    }
   
    @Test
    public void testng() throws Exception
    {
        
        WebElement element=driver.findElement((By.linkText("Mutual Funds")));
        element.click();
        Thread.sleep(2000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
        Thread.sleep(2000);
        Select select1=new Select(driver.findElement((By.name("amc"))));
        Thread.sleep(2000);
        select1.selectByVisibleText("Canara Robeco");
        Thread.sleep(2000);
        Select select2=new Select(driver.findElement((By.name("schemenm"))));
        Thread.sleep(2000);
        select2.selectByVisibleText("Canara Robeco Bluechip Equity Direct-G");
        Thread.sleep(2000);
        driver.findElement((By.linkText("Get Details"))).click();
        Thread.sleep(2000);
        String currentWindowHandle=driver.getWindowHandle();
        Set<String>windowHandles=driver.getWindowHandles();
        for(String handle: windowHandles){
            if(!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
                break;
            }     
        }
        driver.findElement((By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[2]/ul/li/i"))).click();
        Thread.sleep(2000);
        driver.findElement((By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[2]/ul/li/ul/li[1]"))).click();
        Thread.sleep(2000);
        driver.findElement((By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul/li/i"))).click();
        Thread.sleep(2000);
        driver.findElement((By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul/li/ul/li[3]/span"))).click();
        Thread.sleep(2000);
        driver.findElement((By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[4]/ul/li/i"))).click();
        Thread.sleep(2000);
        driver.findElement((By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[4]/ul/li/ul/li[4]/span"))).click();
        Thread.sleep(2000);
        driver.findElement((By.xpath("/html/body/main/div[10]/section[3]/div/ul/li[2]"))).click();
        Thread.sleep(2000);
        WebElement table = driver.findElement(By.xpath("//*[@id='mfReturns']/div[2]/div[2]/ul/li[1]/table"));
        Thread.sleep(2000);
        WebElement firstRow = table
                .findElement(By.xpath("//*[@id='mfReturns']/div[2]/div[2]/ul/li[1]/table/tbody/tr[1]"));
        try {
            List<WebElement> cells = firstRow.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                System.out.println(cell.getText() + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterMethod
    public void aftermethod(){
        driver.quit();
    }
    @AfterTest
    public void aftertest(){
        
    }
}
