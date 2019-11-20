package com.test2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionsTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome()
    {
        System.setProperty("webdriver.chrome.driver","E:\\IDEA\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
    }
    /*
    点击百度首页，新闻链接
     */
    @Test
    public void clickTest()
    {
        driver.get("http://www.baidu.com");
        WebElement newClick=driver.findElement(By.name("tj_trnews"));
        //点击链接
        newClick.click();
        //获取当前页面的url
        String url=driver.getCurrentUrl();
        //校验当前页面是不是新闻页面
        Assert.assertEquals(url,"http://news.baidu.com/");
    }

    /*
    点击百度首页，文本框输入selenium进行搜索
    校验第一行搜索出来的
     */
    @Test
    public void senkeysTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement keys=driver.findElement(By.id("kw"));
        //文本框输入内容
        keys.sendKeys("selenium");
        WebElement button=driver.findElement(By.id("su"));
        button.click();
        //等待
        Thread.sleep(3000);
        String title=driver.getTitle();
        Assert.assertEquals(title,"selenium_百度搜索");
    }

    /*
    点击百度首页，文本框输入selenium,清空文本框
     */
    @Test
    public void clearTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement keys=driver.findElement(By.id("kw"));
        //文本框输入内容
        keys.sendKeys("selenium");
        //等待
        Thread.sleep(3000);
        //清空文本框
        keys.clear();
        Thread.sleep(3000);
    }

    /*
    点击百度首页，文本框输入selenium,获取文本，校验是否为selenium
    清空输入框,在获取文本框
     */
    @Test
    public void getTextTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        String text=driver.findElement(By.name("tj_trnews")).getText();
        Assert.assertEquals(text,"新闻");
        Thread.sleep(3000);
    }

    /*
    点击百度首页，获取文本的togname，校验是否为input
     */
    @Test
    public void getTegnameTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        String tegName=driver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(tegName,"input");
        Thread.sleep(3000);
    }

    /*
    点击百度首页，判断按钮显示的文本值为百度一下
     */
    @Test
    public void getATest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        String a=driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(a,"百度一下");
    }

    /*
    点击百度首页，判断按钮显示百度一下按钮
     */
    @Test
    public void isDisplayedTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        Boolean idp=driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(idp);
    }

    /*
    点击百度首页截图
     */
    @Test
    public void shotTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try
        {
            FileUtils.copyFile(file,new File("E:\\test.png"));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }
}
