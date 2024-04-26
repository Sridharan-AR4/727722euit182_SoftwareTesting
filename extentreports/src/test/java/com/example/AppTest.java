package com.example;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    WebDriver driver;
    ExtentReports reports;
    ExtentTest test;

    @BeforeTest
    public void setup(){
        ExtentSparkReporter ereport=new ExtentSparkReporter("C:\\Users\\asus\\Desktop\\Software Testing\\extentreports\\ExtentReport1.html");
        reports=new ExtentReports();
        reports.attachReporter(ereport);
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        
    }
    @Test
    public void test() throws Exception{
        test=reports.createTest("test started");
       
        driver.get("https://skcet530.examly.io/login");
        String s=driver.getTitle();
        System.out.println(s);

        if(driver.getTitle().equalsIgnoreCase("SKCET")){
            test.log(Status.PASS, "Navigated to the specified url");
        }
        else{
            test.log(Status.FAIL, "test failed");
        }
        
    }
    @AfterTest
    public void after(){
       // reports.endTest(test);
        reports.flush();
        driver.quit();
    }
}
