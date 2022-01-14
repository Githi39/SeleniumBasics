package com.obsqura.seleniumcommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Seleniumobsquraform {
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
    public void VerifyInputform() {
        driver.get("https://selenium.obsqurazone.com/index.php");
        WebElement inputform = driver.findElement(By.xpath("//a[@href='simple-form-demo.php']"));
        inputform.click();
        WebElement messagefield = driver.findElement(By.xpath("//input[@id='single-input-field']"));
        messagefield.sendKeys("testing obsqura form");
        WebElement showbutton = driver.findElement(By.xpath("//button[@id='button-one']"));
        showbutton.click();
        WebElement sucessmsg = driver.findElement(By.xpath("//div[@id='message-one']"));
        String v = sucessmsg.getText();
        System.out.println(v);
        WebElement valueAfield = driver.findElement(By.id("value-a"));
        valueAfield.sendKeys("100");
        WebElement valueBfield = driver.findElement(By.id("value-b"));
        valueBfield.sendKeys("500");
        WebElement gettotal = driver.findElement(By.id("button-two"));
        gettotal.click();
        WebElement sucessmsg2 = driver.findElement(By.id("message-two"));
        String v2 = sucessmsg2.getText();
        System.out.println(v2);
    }

    @Test(priority = 2)
    public void verifysingleCheckboxDemo() {
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        WebElement box = driver.findElement(By.id("gridCheck"));
        box.click();
        WebElement grid = driver.findElement(By.xpath("//input[@id='gridCheck']/following-sibling::label"));
        grid.click();
        boolean slectioncheckbox = box.isDisplayed();
        System.out.println(slectioncheckbox);
        WebElement singlesucessmsg = driver.findElement(By.id("message-one"));
        String v3 = singlesucessmsg.getText();
        System.out.println(v3);
    }

    @Test(priority = 3)
    public void verifymultiplecheckbox() {
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        WebElement box = driver.findElement(By.id("gridCheck"));
        box.click();
        selectCheckbox("Check Box One", "Check Box Two");

    }

    public void selectCheckbox(String value1, String value2) {
        List<WebElement> chkbox = driver.findElements(By.xpath("//input[@class='check-box-list']/following-sibling::label"));
        //System.out.println("total number of checkbox"+chkbox.size());
        for (int i = 0; i < chkbox.size(); i++) {
            String values = chkbox.get(i).getText();
            if (values.equals(value1)) {
                chkbox.get(i).click();
            }
            if (values.equals(value2)) {
                chkbox.get(i).click();
            }


        }

    }

    @Test(priority = 4)
    public void verifyRadiobuttons() {
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        WebElement radiobuttondemo = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
        radiobuttondemo.click();
        WebElement buttonclick = driver.findElement(By.id("button-one"));
        buttonclick.click();
        WebElement showmsg = driver.findElement(By.id("message-one"));
        System.out.println(showmsg.isDisplayed());
    }

    @Test(priority = 5)
    public void verifyGroupRadiobuttons() {
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        WebElement patientGender= driver.findElement(By.id("inlineRadio11"));
        patientGender.click();
        WebElement patientage= driver.findElement(By.id("inlineRadio23"));
        patientage.click();
        WebElement buttopatient= driver.findElement(By.id("button-two"));
        buttopatient.isSelected();
        buttopatient.click();
        WebElement showpatientmsg= driver.findElement(By.id("message-two"));
        String msgs=showpatientmsg.getText();
        System.out.println(msgs);
    }
}
