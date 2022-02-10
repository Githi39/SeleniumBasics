package com.obsqura.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mystore
{
    public static void main (String[] args)
    {
        System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.creativehands.in/my-account/");
        driver.close();
        WebElement data= driver.findElement(By.id("username"));
        System.out.println(data);
    }
}
