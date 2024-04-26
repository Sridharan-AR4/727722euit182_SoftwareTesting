package com.example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
   public void beforetest(){
      // WebDriverManager.chromedriver().setup();
      // driver=new ChromeDriver();
      // driver.manage().window().fullscreen();
      // driver.get("https://www.google.com/");
      System.out.println("beforetest");
   }
   @BeforeMethod
   public void BeforeMethod(){
      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      System.out.println("beforemethod");
   }
   @Test(priority = 0)
   public void test0(){
      driver.get("https://www.google.com/");
    System.out.println("test0");
   }
   @Test(priority = 1)
   public void test1(){
      driver.get("https://leetcode.com/");
    System.out.println("test1");
   }
   @Test(priority = 2)
   public void test2(){
      driver.get("https://www.bing.com/");
    System.out.println("test2");
   }
   @Test(priority = 3)
   public void test3(){
      driver.get("https://github.com/");
    System.out.println("test3");
   }
   @AfterMethod
   public void AfterMethod() throws Exception{
    System.out.println("aftermethod");
    Thread.sleep(3000);
    driver.quit();
   }
   @AfterTest
   public void AfterTest(){
    System.out.println("Aftertest");
   // driver.quit();
   }
}
