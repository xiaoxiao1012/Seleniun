package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class OpenBrowserTest {
    //Firefox
    @Test
    public void openFirefox()
    {
       // System.setProperty("webdriver.gecko.driver", "C:\\Users\\betterda\\Desktop\\geckodriver-v0.19.0-win64\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        WebDriver webDriver=new FirefoxDriver();
    }

    //谷歌
    @Test
    public void openChromeDriver()
    {
        System.setProperty("webdriver.chrome.driver","E:\\IDEA\\driver\\chromedriver.exe");
        WebDriver webDriver=new ChromeDriver();
    }
    //IE
    @Test
    public void openIEDriver()
    {
        System.setProperty("webdriver.ie.driver","E:\\IDEA\\driver\\IEDriverServer.exe");
        WebDriver webDriver=new InternetExplorerDriver();
    }
}
