package com.obsqura.homework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Iterapraticeqa {
    WebDriver driver;

    public void testInitlz() {

        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void setup() {
        testInitlz();
    }

    @AfterMethod
    public void tearDown() {
        //driver.close();
    }

    @Test(priority = 1)
    public void verifyFirstMethod() {
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("githi");
        WebElement phonenum = driver.findElement(By.id("phone"));
        phonenum.sendKeys("9090909090");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("anngithi@gmail.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123abc");
        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys("abc nagar kerala");
        WebElement button1 = driver.findElement(By.xpath("//button[text()='Submit']"));
        Boolean b1 = button1.isDisplayed();
        System.out.println(b1);
        Boolean b2 = button1.isSelected();
        System.out.println(b2);
        Boolean b3 = button1.isEnabled();
        System.out.println(b3);
        button1.click();
    }
    @Test(priority = 16)
    public void windowHandlemethod()
    {
        driver.get("https://demo.guru99.com/popup.php");
        String window1=driver.getWindowHandle(); //return id of the single window browser
        System.out.println(window1);
        WebElement clickwindow= driver.findElement(By.xpath("//p[@style='text-align:center']//a"));
        clickwindow.click();
        Set<String> window2=driver.getWindowHandles(); //return Id's of multiple browser windows
        Iterator<String> it=window2.iterator();
        String parentid= it.next();
        String childwindow=it.next();
        System.out.println(parentid);
        System.out.println(parentid);
    }
    @Test(priority = 2)
    public void VerifySecondmethod()
    {
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
     selectGender("Male");

    }

    public void selectGender(String gender) {
        List<WebElement> genderSelect = driver.findElements(By.xpath("//input[@name='optionsRadios']"));
        for (int i =0; i < genderSelect.size(); i++) {
            String v = genderSelect.get(i).getText();
            if (v.equals(gender))
            {
                genderSelect.get(i).click();
                break;
            }
        }
    }
    @Test(priority = 3)
    public void verifyDynamictables()
    {
        driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
        List<WebElement> allColumns=driver.findElements(By.xpath("//table[@class='dataTable']//th"));
        System.out.println(allColumns.size());
        Assert.assertEquals(allColumns.size(),5,"notmatch");
        for(WebElement elem:allColumns)
        {
            String colvalues=elem.getText();
            System.out.println(colvalues);
        }
    }
}


