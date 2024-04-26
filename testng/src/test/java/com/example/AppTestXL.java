package com.example;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTestXL {
    WebDriver driver;
    @BeforeMethod
    public void setup() throws Exception{
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://dbankdemo.com/bank/login");
    }
    @Test
    public void Test() throws Exception{
        FileInputStream fs=new FileInputStream("D:\\dbankdemo.xlsx");
        XSSFWorkbook  wb=new XSSFWorkbook(fs);
        XSSFSheet sheet1=wb.getSheet("login");
        XSSFRow row1=sheet1.getRow(1);
        String username=row1.getCell(0).getStringCellValue();
        String password=row1.getCell(1).getStringCellValue();
        System.out.println(username+" "+password);
        driver.findElement((By.id("username"))).sendKeys(username);
        driver.findElement((By.id("password"))).sendKeys(password);
        driver.findElement((By.id("submit"))).click();
    }
    @AfterMethod
    public void Testquit(){
        driver.quit();
    }
}
