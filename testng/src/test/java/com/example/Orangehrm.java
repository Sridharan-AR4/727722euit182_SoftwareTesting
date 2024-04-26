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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Orangehrm {
    WebDriver driver;
    @BeforeMethod
    public void setup() throws Exception{
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Test(dataProvider ="dataprovider")
    public void test(String username,String password) throws Exception{
        // FileInputStream fs=new FileInputStream("D:\\Orangehrm.xlsx");
        // XSSFWorkbook wb=new XSSFWorkbook(fs);
        // XSSFSheet login=wb.getSheet("login");
        // XSSFRow row1=login.getRow(1);
        // String username=row1.getCell(0).getStringCellValue();
        // String password=row1.getCell(1).getStringCellValue();
        Thread.sleep((3000));
        driver.findElement((By.xpath("//*[@name='username']"))).sendKeys(username);
        Thread.sleep(2000);
        driver.findElement((By.xpath("//*[@name='password']"))).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement((By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"))).click();
        Thread.sleep(5000);

    }
    @DataProvider(name = "dataprovider")
    public Object[][] fetch() throws Exception{
        Object[][] data=new Object[2][2];
        data[0][0]="sridharan";
        data[0][1]="ssssssss";
        data[1][0]="Admin";
        data[1][1]="admin123";
        return data;

    }
    @AfterMethod
    public void quitdriver(){
        driver.quit();
    }
}
