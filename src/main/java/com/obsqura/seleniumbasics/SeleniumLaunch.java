package com.obsqura.seleniumbasics;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
        driver.get("http://demowebshop.tricentis.com/");
        String actulTitle = driver.getTitle();
        System.out.println(actulTitle);
        //driver.close();
        //testInitlz("Edge");
        //testInitlz("Firefox");
      String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);
        String PageSource = driver.getPageSource();
        System.out.println(PageSource);
        driver.close();
    }
}

