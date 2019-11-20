package com.test3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JsTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome()
    {
        System.setProperty("webdriver.chrome.driver","E:\\IDEA\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    /*
    利用JS
     */
    @Test
    public void exJS() throws InterruptedException {
        driver.get("http://www.baidu.com");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"WebDriver\")");
        Thread.sleep(5000);
    }



    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }
}
