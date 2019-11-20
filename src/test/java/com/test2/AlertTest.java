package com.test2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome()
    {
        System.setProperty("webdriver.chrome.driver","E:\\IDEA\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    /*
    打开UI测试主页
    点击alert
    在alert警告框点击确定按钮
     */
    @Test
    public void alertTest() throws InterruptedException {
        driver.get("file:///E:/xxf/xuexi/selenium_html/selenium_html/index.html");
        driver.findElement(By.className("alert")).click();
        Thread.sleep(2000);
        //driver控制权转交给alert
        Alert alert=driver.switchTo().alert();
        String s=alert.getText();
        alert.accept();
        Assert.assertEquals(s,"请点击确定");
    }

     /*
    打开UI测试主页
    点击Confirm按钮
    在Confirm警告框点击取消按钮
    再次点击确定按钮
     */
     @Test
     public void confirmTest() throws InterruptedException {
         driver.get("file:///E:/xxf/xuexi/selenium_html/selenium_html/index.html");
         driver.findElement(By.className("confirm")).click();
         Thread.sleep(2000);
         ///driver控制权转交给alert
         Alert alert=driver.switchTo().alert();
         //点击取消
         alert.dismiss();
         Thread.sleep(2000);
         //点击确定
         alert.accept();
     }

    /*
   打开UI测试主页
   点击Prompt按钮
   在prompt弹窗中，输入“这个是prompt”
   点击确定按钮
   再次点击确定按钮
    */
    @Test
    public void promptTest() throws InterruptedException {
        System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        WebDriver webDriver=new FirefoxDriver();
        webDriver.get("file:///E:/xxf/xuexi/selenium_html/selenium_html/index.html");
        webDriver.findElement(By.className("prompt")).click();
        Thread.sleep(2000);
        ///driver控制权转交给alert
        Alert alert=webDriver.switchTo().alert();
        alert.sendKeys("这个是prompt");
        Thread.sleep(2000);
        //点击确定
        alert.accept();
        Thread.sleep(2000);
        alert.accept();
    }



    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }
}
