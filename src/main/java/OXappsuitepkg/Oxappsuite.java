package OXappsuitepkg;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Oxappsuite{
    public static void main (String[] args)
    {
        System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://petstore.com/account/login?return_url=%2Faccount");
       WebElement userName=driver.findElement(By.id("CustomerEmail"));
        System.out.println(userName);
        //driver.get("https://www.bigbasket.com/cl/fruits-vegetables/?nc=close#!page=2");
      //  WebElement userID= driver.findElement(By.id("TRUE_TIME_STAMP"));
       // System.out.println(userID);
    }

}
