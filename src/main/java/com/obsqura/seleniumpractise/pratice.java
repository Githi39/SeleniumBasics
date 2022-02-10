package com.obsqura.seleniumpractise;

import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class pratice {
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
            public void verifyfirst() {
        driver.get("https://demo.nopcommerce.com/");
        WebElement username = driver.findElement(By.id("small-searchterms"));
        System.out.println("display status is\t" + username.isDisplayed()); // return true or false
        System.out.println("enable status is\t" + username.isEnabled());
        WebElement register = driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();
        WebElement female = driver.findElement(By.xpath("//input[@value='F']"));
        female.click();
        System.out.println(female.isSelected());
    }

        @Test(priority = 2)
                public void Verifynavigate()
        {
            driver.get("https://demo.nopcommerce.com/");
            WebElement register = driver.findElement(By.xpath("//a[@class='ico-register']"));
            register.click();
            driver.navigate().back();
            driver.navigate().forward();
            driver.navigate().refresh();

        }
        @Test(priority = 3)
    public void verifyChkboxone()
    {

    }

    }

