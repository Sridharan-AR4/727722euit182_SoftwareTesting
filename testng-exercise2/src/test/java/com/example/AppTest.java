package com.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public void openpage() throws Exception{
        String str="https://www.moneycontrol.com/";
        driver.get(str);
        Thread.sleep(2000);
        driver.findElement((By.xpath("/html/body/div/div[1]/span/a"))).click();
    }
    @Test
    public void test() throws Exception
    {

        WebElement searchbox=driver.findElement(By.id("search_str"));
        searchbox.sendKeys("Reliance Industries",Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement((By.xpath("/html/body/header/div[1]/div[1]/div/div/div[2]/div/div/form/div[2]/div[2]/ul/li[1]/a"))).click();
        Thread.sleep(2000);
        driver.navigate().to("https://www.moneycontrol.com/mf/sipcalculator.php");
        Thread.sleep(2000);

        // dropdown box ---1
        driver.findElement(By.xpath("//*[@id=\"ff_id\"]/option[3]")).click();
        Thread.sleep(2000);
        // dropdown box ---2
        driver.findElement(By.xpath("//*[@id=\"im_id\"]/option[2]")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("invamt")).sendKeys("100000");
        Thread.sleep(2000);

         //strt date
         driver.findElement(By.id("stdt")).sendKeys("2021-08-02");
         Thread.sleep(1000);
         
         //end date // clicking button
         driver.findElement(By.id("endt")).sendKeys("2023-08-17",Keys.ENTER);
         Thread.sleep(1000);
         
         String dt = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
         String amt = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]")).getText();
         
         System.out.println(dt);
         System.out.println(amt);
         // driver.quit();

    }
}