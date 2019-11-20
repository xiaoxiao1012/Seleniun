package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindElementTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome()
    {
        System.setProperty("webdriver.chrome.driver","E:\\IDEA\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
    }
    /*
    打开百度，通过id定位搜索文本框
     */
    @Test
    public void byIDTest(){
        driver.get("https://www.baidu.com");
        WebElement keyField=driver.findElement(By.id("kw"));
    }

    /*
    打开百度，通过name定位搜索文本框
     */
    @Test
    public void byNameTest(){
        driver.get("https://www.baidu.com");
        WebElement keyField=driver.findElement(By.name("wd"));
    }

    /*
    打开百度，通过class定位搜索文本框
     */
    @Test
    public void byClassTest(){
        driver.get("https://www.baidu.com");
        WebElement keyField=driver.findElement(By.className("bg s_btn"));
    }

    /*
    打开百度，通过xpath定位搜索文本框
     */
    @Test
    public void byXpathTest(){
        driver.get("https://www.baidu.com");
        WebElement el=driver.findElement(By.xpath("//*[@id=\"su\"]"));
    }

    /*
    打开百度，通过css定位搜索文本框
     */
    @Test
    public void byCSSTest(){
        driver.get("https://www.baidu.com");
        WebElement el=driver.findElement(By.cssSelector("#su"));
    }

    @AfterMethod
    public void closeChrome()
    {
        driver.quit();
    }

}
