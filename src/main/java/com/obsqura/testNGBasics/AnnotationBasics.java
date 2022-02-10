package com.obsqura.testNGBasics;


import org.testng.annotations.*;

public class AnnotationBasics
{
    @BeforeSuite
    public void beforesuiteMethod()
    {
        System.out.println("this is before suite method");
    }
    @BeforeTest
    public void beforeTestMethod()
    {
        System.out.println("this is before test method");
    }
    @BeforeClass
    public void beforeClassMethod()
    {
        System.out.println("this is before class method");
    }
    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("this is before method");
    }
    @AfterSuite
    public void aftersuiteMethod()
    {
        System.out.println("this is after suite method");
    }
    @AfterTest
    public void afterTestMethod()
    {
        System.out.println("this is after test method");
    }
    @AfterClass
    public void afterClassMethod()
    {
        System.out.println("this is after class method");
    }
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("this is after method");
    }

    @Test(priority = 1)
    public void verifyTestcaseOne()
    {
        System.out.println("test case 1");
    }
    @Test(priority = 1)
    public void verifyTestcaseTwo()
    {
        System.out.println("test case two");
    }
    @Test(priority = 1)
    public void verifyTestcaseThree()
    {
        System.out.println("test case three");
    }
}
