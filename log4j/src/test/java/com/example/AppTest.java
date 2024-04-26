package com.example;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    static Logger logger=Logger.getLogger(AppTest.class);
    FileInputStream fs;
    @Test
    public void test() throws Exception
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PropertyConfigurator.configure("C:\\Users\\asus\\Desktop\\Software Testing\\log4j\\src\\main\\java\\com\\example\\resources\\log4j.properties");
        fs=new FileInputStream("D:\\Softwaretesting-XL Files\\SKCET.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(fs);
        XSSFSheet login=wb.getSheet("login");
        XSSFRow row1=login.getRow(1);
        String email=row1.getCell(0).getStringCellValue();
        String passowrd=row1.getCell(1).getStringCellValue();
        driver.get("https://skcet530.examly.io/login"); 
        logger.info("Opened skcet login page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-login/div/div/div[2]/app-dynamic/div[3]/div/div/app-form-builder/div/form/div[1]/app-field-builder/div/div/email/div/div/span[1]/input"))).sendKeys(email);
        logger.info("entered email");
        driver.findElement((By.xpath("/html/body/app-root/div/div/div/app-login/div/div/div[2]/app-dynamic/div[3]/div/div/div[1]/app-button/button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-login/div/div/div[2]/app-dynamic/div[3]/div/div/app-form-builder/div/form/div[2]/app-field-builder/div/div/email/div/div/span/input"))).sendKeys(passowrd);
        logger.info("entered password"); 
        driver.findElement((By.xpath("/html/body/app-root/div/div/div/app-login/div/div/div[2]/app-dynamic/div[3]/div/div/div/app-button/button"))).click();
        logger.info("login successfully");
        driver.quit();
        
    }
}
