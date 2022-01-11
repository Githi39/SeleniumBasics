package com.obsqura.seleniumcommands;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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

    @AfterMethod
    public void tearDown() {
        //driver.close();
    }

    @Test(priority = 1)
    public void verifyLogin() {
        driver.get("http://demowebshop.tricentis.com/");
        WebElement loginMenu = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginMenu.click();
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("githi1234@gmail.com");
        //email.clear();
        WebElement password = driver.findElement(By.xpath("//input[@class='password']"));
        password.sendKeys("g123J45678");
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        String value = loginButton.getAttribute("value");
        System.out.println(value);
        String v2 = loginButton.getTagName();
        System.out.println(v2);
        Point Location = loginButton.getLocation();
        System.out.println(Location.x);
        Dimension size = loginButton.getSize();
        System.out.println(size.width);
        Boolean enablestatus = loginButton.isEnabled();
        System.out.println(enablestatus);
        Boolean buttondusplayed = loginButton.isDisplayed();
        System.out.println(buttondusplayed);

        loginButton.click();

    }

    @Test(priority = 2)
    public void verifyRegister() {
        driver.get("http://demowebshop.tricentis.com/");
        WebElement registerMenu = driver.findElement(By.xpath("//a[@class='ico-register']"));
        registerMenu.click();
        WebElement radiofemale = driver.findElement(By.id("gender-female"));
        boolean selectionstatus = radiofemale.isSelected();
        System.out.println(selectionstatus);
        radiofemale.click();
        boolean selectionstatus2 = radiofemale.isSelected();
        System.out.println(selectionstatus2);
        WebElement firstname = driver.findElement(By.xpath("//input[@class='text-box single-line']"));
        firstname.sendKeys("githi");
        WebElement lastname = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastname.sendKeys("babu");
        WebElement Emailfield = driver.findElement(By.xpath("//input[@id='Email']"));
        Emailfield.sendKeys("githi123456@gmail.com");
        WebElement passwordfield = driver.findElement(By.xpath("//input[@type='password']"));
        passwordfield.sendKeys("g123J4567890");
        WebElement confirmpasswordfield = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmpasswordfield.sendKeys("g123J4567890");
        WebElement registerButton = driver.findElement(By.xpath("//input[@id='register-button']"));
        String value = registerButton.getAttribute("value");
        System.out.println(value);
        registerButton.click();
        WebElement registermsg = driver.findElement(By.xpath("//div[@class='result']"));
        String v1 = registermsg.getText();
        System.out.println(v1);


    }

    @Test(priority = 3)
    public void verifyfindelemnts() {
        driver.get("http://demowebshop.tricentis.com/");
        WebElement registerMenu = driver.findElement(By.xpath("//a[@class='ico-register']"));
        registerMenu.click();
        selectGender("Female");
    }

    public void selectGender(String gender) {
        List<WebElement> genderselection = driver.findElements(By.xpath("//label[@for='gender-male' or @ for='gender-female']"));
        for (int i = 0; i < genderselection.size(); i++) {

            String value = genderselection.get(i).getText();
            if (value.equals(gender)) {
                genderselection.get(i).click();
                break;
            }
        }

    }

    @Test(priority = 4)
    public void verifycommunitypoll() {
        driver.get("http://demowebshop.tricentis.com/");
        WebElement pollmenu = driver.findElement(By.xpath("//input[@type='radio']"));
        //WebElement registerMenu = driver.findElement(By.xpath("//a[@class='ico-register']"));
      pollmenu.click();
        selectpoll("Poor");
    }

    public void selectpoll(String name) {
        List<WebElement> pollselection = driver.findElements(By.xpath("//input[@type='radio']"));
        for (int i = 0; i < pollselection.size(); i++) {
            String value = pollselection.get(i).getText();
            if (value.equals(name)) {
                pollselection.get(i).click();
                break;
            }
        }
    }


    @Test(priority = 5)
    public void Verifynavigationcommands() {
        driver.get("http://demowebshop.tricentis.com/");
        WebElement registerMenu = driver.findElement(By.xpath("//a[@class='ico-register']"));
        registerMenu.click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.navigate().to("https://www.google.com/");
    }
}
