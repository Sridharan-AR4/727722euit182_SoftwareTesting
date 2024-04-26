package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setup() throws Exception{
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.ixigo.com/");
    }
    @Test(priority = 0)
    public void test1() throws Exception{
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[1]/div[1]/div/button[2]")))).click();
        WebElement from=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/input"))));
        WebElement to=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/input"))));
        Thread.sleep(2000);
        from.clear();
        Thread.sleep(2000);
        to.clear();

    }

}
    
