package com.example;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.commons.math3.analysis.function.Exp;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
        FileInputStream fs=new FileInputStream("D:\\Softwaretesting-XL Files\\ixigo-travel.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(fs);
        XSSFSheet sheet=wb.getSheet("Sheet1");
        XSSFRow row1=sheet.getRow(1);
        String fr=row1.getCell(0).getStringCellValue();
        String t=row1.getCell(1).getStringCellValue();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[1]/div[1]/div/button[2]")))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div/div/div/p[2]")))).click();
        WebElement from=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/input"))));
        from.sendKeys(fr);
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div")))).click();
        WebElement to=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/input"))));
        to.sendKeys(t);
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[3]/div[1]/li/div[2]/p[2]")))).click();

        

    }

}
    
