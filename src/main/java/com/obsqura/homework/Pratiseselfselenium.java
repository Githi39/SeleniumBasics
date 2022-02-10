package com.obsqura.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Pratiseselfselenium {
    WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://shop.demoqa.com/";
        driver.get(url);
        String title = driver.getTitle();
        int titlelength = driver.getTitle().length();
        System.out.println(title);
        System.out.println(titlelength);
        String pageurl = driver.getCurrentUrl();
        System.out.println(pageurl);
        if (url.equals(pageurl)) {
            System.out.println("both are same");
        } else {
            System.out.println("different url");
        }
        String pagesource = driver.getPageSource();
        int pagesourcelength = driver.getPageSource().length();
        System.out.println(pagesource);
        System.out.println(pagesourcelength);
        driver.close();
    }
}
