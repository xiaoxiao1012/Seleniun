package com.test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class BrowserActionsTest {

    WebDriver driver;
    @BeforeMethod
    public void openChrome()
    {
        System.setProperty("webdriver.chrome.driver","E:\\IDEA\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
    }
    /*
    * 打开浏览器，打开百度首页，等待5s，关闭浏览器
    * */
    @Test
    public void getTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(5000);
    }
    /*
     * 打开浏览器，打开百度首页，等待3s，后退浏览器，等待3s，关闭
     * */
    @Test
    public void backTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        //后退浏览器
        driver.navigate().back();
        Thread.sleep(3000);
    }

    /*
     * 打开浏览器，打开百度首页，等待3s，前进浏览器，等待3s，关闭
     * */
    @Test
    public void forwardTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        //后退浏览器
        driver.navigate().back();
        Thread.sleep(3000);
        //前进
        driver.navigate().forward();
        Thread.sleep(3000);
    }

    /*
     * 打开浏览器，打开google首页，等待3s，刷新，等待3s，关闭
     * */
    @Test
    public void refreashTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        //刷新浏览器
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    /*
     * 打开浏览器，设置窗口大小，等待3s，最大化，等待3s，关闭
     * */
    @Test
    public void winTest() throws InterruptedException {
        //设置浏览器窗口大小
        Dimension dimension=new Dimension(300,300);
        driver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        //浏览器最大化
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    /**
     * 打开chrome浏览器，打开百度首页，等待3s，
     * 获取当前页面的url，
     * 校验当前页面url是不是百度页面，关闭浏览器
     */
    @Test
    public void getURLTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        String url=driver.getCurrentUrl();
        Thread.sleep(3000);
        System.out.println("获取到的URl是："+url);
        Assert.assertEquals(url,"https://www.baidu.com/");
        driver.quit();
    }

    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }
}
