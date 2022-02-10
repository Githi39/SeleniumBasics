package com.obsqura.testNGBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationBasicsTwo
{

    @Test(priority = 1)
    public void verifyTestcaseFour()
    {
        System.out.println("test case 4");
    }
    @Test(priority = 1)
    public void verifyTestcasefive()
    {
        System.out.println("test case 5");
    }
    @Test(priority = 1)
    public void verifyTestcasesix()
    {
        System.out.println("test case 6");
    }
}

