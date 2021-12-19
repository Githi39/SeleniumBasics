package com.obsqura.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Petsworld
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.petsworld.in/customer/account/login");
        WebElement userName=driver.findElement(By.id("email"));
        System.out.println(userName);
        WebElement userName1 = driver.findElement(By.name("login[username]"));
        System.out.println(userName1);
        WebElement userName2 = driver.findElement(By.className("input-text"));
        System.out.println(userName2);
        WebElement userName3 = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        System.out.println(userName3);
        WebElement userName4 = driver.findElement(By.cssSelector("#email"));
        System.out.println(userName4);
        WebElement userName5 =driver.findElement(By.linkText("sign in"));
        System.out.println(userName5);
        WebElement userName6 =driver.findElement(By.partialLinkText("sign"));
        System.out.println(userName6);
        List<WebElement> tags =driver.findElements(By.tagName("input"));
        System.out.println(tags.size());
        System.out.println(tags);

    }
}
