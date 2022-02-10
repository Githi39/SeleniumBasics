package com.obsqura.seleniumpractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumcodePractise {
    public static void main(String args[])
    {
        System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://demo.guru99.com/test/newtours/");
        //driver.close();
        String actulTitle = driver.getTitle();
        System.out.println(actulTitle);
        String PageSource = driver.getPageSource();
       System.out.println(PageSource);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }
}
