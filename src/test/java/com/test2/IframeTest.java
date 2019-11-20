package com.test2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome()
    {
        System.setProperty("webdriver.chrome.driver","E:\\IDEA\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    /*
    打开测试界面
    点击百度链接
     */
    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("file:///E:/xxf/xuexi/selenium_html/selenium_html/index.html");
        //通过ID或name方式转交控制权
        //driver.switchTo().frame("aa");
        //通过webelement方式
        WebElement iframe=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);
        //driver控制权转交给原来的界面
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Open new window")).click();
    }

    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }
}
