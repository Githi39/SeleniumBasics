package com.obsqura.seleniumcommands;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
        testInitlz("Firefox");
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
        String expmsg = "Registration sucessfull";
        String actMsg = "Registration sucessfull";
        Assert.assertEquals(actMsg, expmsg, "error:message");
        //System.out.println(v1);


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
        selectPoll("Poor");
    }

    public void selectPoll(String name) {
        List<WebElement> pollselection = driver.findElements(By.xpath("//input[@type='radio']/following-sibling::label"));
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

    @Test(priority = 6)
    public void verifyDropdowns() {
        driver.get("https://demo.guru99.com/selenium/newtours/");
        WebElement mregister = driver.findElement(By.xpath("//a[@href='register.php']"));
        mregister.click();
        WebElement countrydropdown = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(countrydropdown);
        //select.selectByVisibleText("INDIA");
        //select.selectByValue("EUROPA ISLAND");
        select.selectByIndex(2);
        List<String> expdropdownvalues = new ArrayList<>();
        expdropdownvalues.add("ALBANIA");
        expdropdownvalues.add("ALGERIA");
        expdropdownvalues.add("AMERICAN SAMOA");
        List<WebElement> dropDownobjects = select.getOptions();
        List<String> actdropdownvalues = new ArrayList<>();
        for (int i = 0; i < dropDownobjects.size(); i++) {
            actdropdownvalues.add(dropDownobjects.get(i).getText());
        }
        for (int x = 0; x < expdropdownvalues.size(); x++) {
            for (int y = 0; y < actdropdownvalues.size(); y++) {
                if (x == y) {
                    Assert.assertEquals(actdropdownvalues.get(x), expdropdownvalues.get(y), "ERROR::Invalid value");
                    System.out.println(expdropdownvalues);
                    System.out.println(actdropdownvalues);
                }
            }
        }

    }

    @Test(priority = 6)
    public void verifyFileUpload() {
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement chooseFile = driver.findElement(By.id("uploadfile_0"));
        chooseFile.sendKeys("D:\\selenium\\SELENIUMTEST.txt");
        WebElement chkBoxAcceptFile = driver.findElement(By.xpath("//input[@id='terms']"));
        chkBoxAcceptFile.click();
        WebElement btnSubmitFile = driver.findElement(By.id("submitbutton"));
        btnSubmitFile.click();
    }

    @Test(priority = 7)
    public void verifySimpleAlert() {
        driver.get(" https://demoqa.com/alerts");
        WebElement btnClickMe = driver.findElement(By.id("alertButton"));
        btnClickMe.click();

        Alert alert = driver.switchTo().alert();
        String actAlertTxt = alert.getText();
        System.out.println(actAlertTxt);
        alert.accept();
    }

    @Test(priority = 8)
    public void verifyConfirmationAlert() {
        driver.get("https://demoqa.com/alerts");
        WebElement btnConfrm = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        btnConfrm.click();
        Alert alert = driver.switchTo().alert();
        String actAlertText = alert.getText();
        System.out.println(actAlertText);
        //alert.accept();
        alert.dismiss();
        WebElement confirmText = driver.findElement(By.id("confirmResult"));
        String cText = confirmText.getText();
        System.out.println(cText);
    }

    @Test(priority = 9)
    public void verifyPromptAlert() {
        driver.get("https://demoqa.com/alerts");
        WebElement btnPromptAlert = driver.findElement(By.id("promtButton"));
        btnPromptAlert.click();
        Alert alert = driver.switchTo().alert();
        String actAlrtTxt = alert.getText();
        System.out.println(actAlrtTxt);
        alert.sendKeys("raj");
        alert.accept();
    }

    @Test(priority = 10)
    public void verifymouseRightclick() {
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement rightclicks = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightclicks).build().perform();
    }

    @Test(priority = 11)
    public void verifymouseDoubleclick() {
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement doubleclicks = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']//following-sibling::button"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleclicks).build().perform();
        Alert alerts = driver.switchTo().alert();
        alerts.accept();


    }

    @Test(priority = 12)
    public void verifymouseDragDrop() {
        driver.get("https://demoqa.com/droppable");
        WebElement drags = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drops = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//following-sibling::div[@id='droppable']"));
        Actions action = new Actions(driver);
        action.dragAndDrop(drags, drops).build().perform();
    }

    @Test(priority = 13)
    public void verifyDragby() {
        driver.get("https://demoqa.com/dragabble");
        WebElement dragboxes = driver.findElement(By.xpath("//div[@id='dragBox']"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(dragboxes, 100, 100).build().perform();
    }

    @Test(priority = 14)
    public void mouseHoverActions() {
        driver.get("https://demoqa.com/menu/");
        selectMainitems("Main Item 2");
        selectMainitems("SUB SUB LIST »");


    }

    public void selectMainitems(String itemname) {
        List<WebElement> mainitem = driver.findElements(By.xpath("//ul[@id='nav']//a"));
        for (int i = 0; i < mainitem.size(); i++) {
            String vnum = mainitem.get(i).getText();
            if (vnum.equals(itemname)) {
                Actions actions = new Actions(driver);
                actions.moveToElement(mainitem.get(i)).build().perform();

            }
        }

    }

    @Test(priority = 15)
    public void verifyClickAndHold()
    {
        driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
        WebElement c=driver.findElement(By.xpath("//li[@name='C']"));
        WebElement l=driver.findElement(By.xpath("//li[@name='L']"));
        Actions action= new Actions(driver);
        //  action.moveToElement(c);
        // action.clickAndHold().build().perform();
        action.clickAndHold(c).moveToElement(l);
        action.release(l).build().perform();
    }

    @Test(priority = 18)
    public void verifyRelease()
    {
        driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
        WebElement drag=driver.findElement(By.id("draggable"));
        WebElement drop=driver.findElement(By.id("droppable"));
        Actions actions =new Actions(driver);
        actions.clickAndHold(drag).moveToElement(drop);
        actions.release().build().perform();

    }

    @Test(priority = 16)
    public void verifyWindowHandle() {
        driver.get("https://demo.guru99.com/popup.php");
        String parentWindow = driver.getWindowHandle();
        System.out.println(parentWindow);
        WebElement clickHere = driver.findElement(By.xpath("//p[@style='text-align:center']//a"));
        clickHere.click();
        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows);
        Iterator<String> iterator = windows.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!parentWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);
                WebElement emailId = driver.findElement(By.xpath("//input[@type='text' and @name='emailid']"));
                emailId.sendKeys("helloo123@gmail.com");
                WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit' and @name='btnLogin']"));
                submitButton.click();
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
    }

    @Test(priority = 17)
    public void verifyFramesusingSelenium() {
        driver.get("https://demoqa.com/frames");
        //driver.switchTo().frame("frame1");
        // driver.switchTo().frame(2);
        WebElement frameElement = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameElement);
        WebElement frametext = driver.findElement(By.id("sampleHeading"));
        System.out.println(frametext.getText());
        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent();
    }

    @Test(priority = 18)
    public void pageLoadwait() {
        driver.get("https://www.myntra.com/");
        //driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); //before selenium 4
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); //selenium 4
    }

    @Test(priority = 19)
    public void implicitWaitinSelenium() {
        driver.get("http://demowebshop.tricentis.com/");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // selenium 4 supports this

        //WebDriverWait wait = new WebDriverWait(driver,20); //before selenium 4
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // after selenium4
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ico-register")));
        WebElement registerMenu = driver.findElement(By.xpath("//a[@class='ico-register']"));
        registerMenu.click();
    }

    @Test(priority = 20)
    public void explicitWaitinSelenium() {
        driver.get("http://demowebshop.tricentis.com/login");
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("githi1234@gmail.com");
        //email.clear();
        WebElement password = driver.findElement(By.xpath("//input[@class='password']"));
        password.sendKeys("g123J45678");
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@value,'Log in')]")));

    }

    @Test(priority = 21)
    public void robotmethod() throws AWTException {
        driver.get("http://demowebshop.tricentis.com/login");
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("githi1234@gmail.com");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        WebElement password = driver.findElement(By.xpath("//input[@class='password']"));
        password.sendKeys("g123J45678");
        robot.keyPress(KeyEvent.VK_ENTER);

    }

    @Test(priority = 22)
    public void fileUploadUsingRobotClass() throws AWTException, InterruptedException {
        driver.get("https://www.naukri.com/registration/createAccount");
        Thread.sleep(2000);
        //WebElement uploadButton= driver.findElement(By.xpath("//button[text()='Upload Resume']"));
        WebElement uploadButton = driver.findElement(By.xpath("//button[@class='uploadResume resman-btn-primary resman-btn-small']"));
        uploadButton.click();
        StringSelection select = new StringSelection("D:\\selenium\\SELENIUMTEST.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null); // copied to clipboard
        Robot robot = new Robot();
        //robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    @Test(priority = 23)
    public void verifyTable() {
        driver.get("https://www.w3schools.com/html/html_tables.asp");

        List<String> actData = new ArrayList<>();
        List<String> expData = new ArrayList<>(Arrays.asList("Island Trading", "Helen Bennett", "UK"));
        List<WebElement> rowElement = driver.findElements(By.xpath("//table[@id='customers']//tr")); //finds the row values
        System.out.println(rowElement.size());
        for (int i = 2; i < rowElement.size(); i++) {
            List<WebElement> colElement = driver.findElements(By.xpath("//table[@id='customers']//tr[" + i + "]//td"));
            String cellValue = colElement.get(0).getText();
            if (cellValue.equals("Island Trading")) {
                for (int j = 0; j < colElement.size(); j++) {
                    String value = colElement.get(j).getText();
                    actData.add(value);
                }
            }
        }
        System.out.println(actData);
        Assert.assertEquals(actData, expData, "ERROR::Invalid Message");
    }

    @Test(priority = 24)
    public void verifyUsingUtility() {
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        List<String> actData = new ArrayList<>();
        List<String> expData = new ArrayList<>(Arrays.asList("Island Trading", "Helen Bennett", "UK"));
        List<WebElement> rowElement = driver.findElements(By.xpath("//table[@id='customers']//tr"));
        List<WebElement> colElement = driver.findElements(By.xpath("//table[@id='customers']//tr//td"));
        List<ArrayList<String>> dataTable = Tableutility.get_Dynamic_TwoDimension_TablElemnts(rowElement, colElement);
        System.out.println(dataTable);
        //String value=dataTable.get(3).get(0);
        //System.out.println(value);
        for (int i = 0; i < dataTable.size(); i++) {
            String value = dataTable.get(i).get(0);
            if (value.equals("Island Trading")) {
                for (int j = 0; j < dataTable.get(0).size(); j++) {
                    actData.add(dataTable.get(i).get(j));

                }
            }
        }
        System.out.println(actData);
        Assert.assertEquals(actData, expData, "Island trading not present in table");

    }
}



