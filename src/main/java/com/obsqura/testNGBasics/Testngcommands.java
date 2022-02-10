package com.obsqura.testNGBasics;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.obsqura.one.Excel;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;

public class Testngcommands {
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
    @Parameters({"browser","url"})
    public void setup(String browserName,String baseUrl) {
        testInitlz(browserName);
        driver.get(baseUrl);
    }




    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        //if(ITestResult.FAILURE== result.getStatus()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenShot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File("./Screenshots/" + result.getName() + ".png"));

        //}
        driver.close();
    }
    @Test(priority = 1,dataProvider = "UserCredentials")
    public void verifyLogin(String uname,String pword) {
        WebElement loginMenu = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginMenu.click();
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys(uname);
        WebElement password = driver.findElement(By.cssSelector("#Password"));
        password.sendKeys(pword);
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginButton.click();
    }
    @DataProvider(name="UserCredentials")
    public Object[][] userCredentialData(){
        Object data[][]=new Object[2][2];
        data[0][0]="rajeena123@gmail.com";
        data[0][1]="rajeena123";
        data[1][0]="minnu123@gmail.com";
        data[1][1]="minnu123";
        return data;
    }
    @Test(priority=4)
    public void verifyHardAssert()
    {
        WebElement loginMenu = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginMenu.click();
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("githi1234@gmail.com");
        //email.clear();
        WebElement password = driver.findElement(By.xpath("//input[@class='password']"));
        password.sendKeys("g123J45678");
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginButton.click();
        WebElement logoutButton = driver.findElement(By.xpath ("//a[@class='ico-logout']"));
        String expmsg = "githi1234@gmail.com";
        String actMsg = email.getText();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actMsg, expmsg, "error:message");
        logoutButton.click();
        System.out.println("this is after method");
        softAssert.assertAll();

    }
    @Test(priority = 5)
    public void verifyLoginFromExcel() throws IOException, InterruptedException {
        List<String> excelList = new ArrayList<String>();
        ExcelUtility excel = new ExcelUtility();
        String excelPath = "//src//main//resources//loginbooknew.xlsx";

        String excelSheetName = "loginbook";

        excelList = excel.readDataFromExcel(excelPath, excelSheetName);
        for(int i=0;i<excelList.size();i++) {
            System.out.println(excelList.get(i));
            WebElement loginMenu = driver.findElement(By.xpath("//a[@class='ico-login']"));
            loginMenu.click();
            driver.findElement(By.id("Email")).sendKeys(excelList.get(i));
            driver.findElement(By.cssSelector("#Password")).sendKeys(excelList.get(i+1));
            Thread.sleep(2000);
            WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
            loginButton.click();
            Thread.sleep(2000);
            WebElement logOutButton = driver.findElement(By.xpath("//div[@class='header-links']//li//a[@class='ico-logout']"));
            logOutButton.click();

        }

    }
}
