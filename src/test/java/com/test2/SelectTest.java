package com.test2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;


public class SelectTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome()
    {
        System.setProperty("webdriver.chrome.driver","E:\\IDEA\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    /*
     *打开我们的测试界面
     * 下拉框选择vivo
     * 第二次选择huawei
     * 第三次选择iphone
     */
    @Test
    public void selectTest() throws InterruptedException {
        driver.get("file:///E:/xxf/xuexi/selenium_html/selenium_html/index.html");
        WebElement selectel=driver.findElement(By.id("moreSelect"));
        //实例化select
        Select select=new Select(selectel);
        //通过索引选择下拉框
        select.selectByIndex(2);
        Thread.sleep(5);
        //通过属性value选择下拉框
        select.selectByValue("huawei");
        Thread.sleep(5);
        //通过文本值选择下拉框
        select.selectByVisibleText("iphone");
        Thread.sleep(5);
    }

    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }

}
