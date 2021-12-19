package com.obsqura.seleniumbasics;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class SeleniumLaunch {
    static WebDriver driver;

    public static void testInitlz(String browser) {
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("Edge")) {
            System.setProperty("webdriver.edge.driver", "D:\\selenium\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "D:\\selenium\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else
            try {
                throw new Exception("INVALID BROWSER NAME");
            } catch (Exception e) {
                e.printStackTrace();
            }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }


    public static void main(String args[]) {
        testInitlz("Chrome");
        driver.get("http://demowebshop.tricentis.com/login");
        //String actulTitle = driver.getTitle();
        //System.out.println(actulTitle);
        //driver.close();
        //testInitlz("Edge");
        //testInitlz("Firefox");
        //String actualUrl = driver.getCurrentUrl();
        // System.out.println(actualUrl);
        //String PageSource = driver.getPageSource();
        // System.out.println(PageSource);
        // driver.manage().window().maximize();
        // driver.manage().deleteAllCookies();
        //driver.close();
        WebElement userName = driver.findElement(By.id("Email"));
        System.out.println(userName);
        WebElement userName1 = driver.findElement(By.name("Email"));
        System.out.println(userName1);
        WebElement userName2 = driver.findElement(By.className("email"));
        System.out.println(userName2);
        WebElement userName3 = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        System.out.println(userName3);
        WebElement userName4 = driver.findElement(By.cssSelector("#Email"));
        System.out.println(userName4);
        WebElement userName5 =driver.findElement(By.linkText("Log in"));
        WebElement userName6 =driver.findElement(By.partialLinkText("Log"));
        List<WebElement> tags =driver.findElements(By.tagName("input"));
        System.out.println(tags.size());
        System.out.println(tags);


    }
}

