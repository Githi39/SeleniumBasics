package com.obsqura.seleniumcommands;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Seleniumpracticecommands {
    WebDriver driver;

    public void testInitlz(String browser) {
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

    @BeforeMethod
    public void setup() {
        testInitlz("Chrome");
    }

    @AfterMethod
    public void tearDown() {
        //driver.close();
    }

    @Test(priority = 1)
    public void verifyLoginofclothsite()
    {
     driver.get("https://cottonworld.net/");
        WebElement signinmenu= driver.findElement(By.xpath("//a[@id='customer_login_link']"));
        signinmenu.click();
        WebElement email= driver.findElement(By.id("CustomerEmail"));
        email.sendKeys("propixeleyes@gmail.com");
        WebElement password= driver.findElement(By.className("input-full"));
        password.sendKeys("pro123pixel");
        WebElement siginbutton=driver.findElement(By.xpath("//input[@value=\"Sign In\"]"));
        String v1=siginbutton.getTagName();
        System.out.println(v1);
        Point Location =siginbutton.getLocation();
        System.out.println(Location.x);
        Dimension size= siginbutton.getSize();
        System.out.println(size.width);
        Boolean enablestatus= siginbutton.isEnabled();
        System.out.println(enablestatus);
        Boolean buttondusplayed=siginbutton.isDisplayed();
        System.out.println(buttondusplayed);
        siginbutton.click();
    }
}