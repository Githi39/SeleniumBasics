package com.obsqura.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Swiggy {

        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.swiggy.com/");
            WebElement userName = driver.findElement(By.id("mobile"));
            System.out.println(userName);
           /* WebElement userName1 = driver.findElement(By.name("mobile"));
            System.out.println(userName1);
            WebElement userName2 = driver.findElement(By.className("_381fS"));
            System.out.println(userName2);
            WebElement userName3 = driver.findElement(By.xpath("//*[@id=\"mobile\"]"));
            System.out.println(userName3);
            WebElement userName4 = driver.findElement(By.cssSelector("#mobile"));
            System.out.println(userName4);
            WebElement userName5 = driver.findElement(By.linkText("Login"));
            System.out.println(userName5);
            WebElement userName6 = driver.findElement(By.partialLinkText("Log"));
            System.out.println(userName6);
            List<WebElement> tags = driver.findElements(By.tagName("input"));
            System.out.println(tags.size());
            System.out.println(tags);*/
        }
    }

