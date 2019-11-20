package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CloseBrowerTest {
    @Test
    public void closeChrome() throws InterruptedException
    {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","E:\\IDEA\\driver\\chromedriver.exe");
        //实例化chromeDriver
        WebDriver webDriver=new ChromeDriver();
        //等待5s
        Thread.sleep(5000);
        //关闭当前窗口
        webDriver.close();
    }

    @Test
    public void closeChrome1() throws InterruptedException
    {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","E:\\IDEA\\driver\\chromedriver.exe");
        //实例化chromeDriver
        WebDriver driver=new ChromeDriver();
        //等待5s
        Thread.sleep(5000);
        //完全退出浏览器
        driver.quit();
    }
}
