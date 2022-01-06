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

public class Seleniumcommands {
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

   // @AfterMethod
    //public void tearDown() {
    //    driver.close();
    //}

    @Test(priority = 1)
    public void verifyLogin() {
        driver.get("http://demowebshop.tricentis.com/");
        WebElement loginMenu = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginMenu.click();
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("rajeena123@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@class='password']"));
        password.sendKeys("rajeena123");
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        String value = loginButton.getAttribute("value");
        System.out.println(value);
        loginButton.click();
    }
    @Test(priority = 2)
    public void verifyRegister() {
        driver.get("http://demowebshop.tricentis.com/");
        WebElement registerMenu = driver.findElement(By.xpath("//a[@class='ico-register']"));
        registerMenu.click();
        WebElement radioMale = driver.findElement(By.id("gender-female"));
        radioMale.click();
        WebElement firstname = driver.findElement(By.xpath("//input[@class='text-box single-line']"));
        firstname.sendKeys("githi");
        WebElement lastname = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastname.sendKeys("babu");
        WebElement Emailfield = driver.findElement(By.xpath("//input[@id='Email']"));
        Emailfield.sendKeys("githi39@gmail.com");
        String V= Emailfield.getText();
        System.out.println("Text content is : " + V);
        WebElement passwordfield = driver.findElement(By.xpath("//input[@type='password']"));
        passwordfield.sendKeys("g123456");
        WebElement confirmpasswordfield = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmpasswordfield.sendKeys("g123456");
        WebElement registerButton = driver.findElement(By.xpath("//input[@id='register-button']"));
        String value = registerButton.getAttribute("value");
        System.out.println(value);
        registerButton.click();
    }

}
