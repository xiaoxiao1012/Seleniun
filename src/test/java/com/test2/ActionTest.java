package com.test2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class ActionTest {

    WebDriver driver;
    @BeforeMethod
    public void openChrome()
    {
        System.setProperty("webdriver.chrome.driver","E:\\IDEA\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    /*
    打开百度页面
    在百度一下按钮上右键
     */
    @Test
    public void rightClick() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement buttonBaidu=driver.findElement(By.id("su"));
        //实例化Actions
        Actions actions=new Actions(driver);
        //右键
        actions.contextClick(buttonBaidu).perform();
        Thread.sleep(3000);
    }

    /*
    打开百度页面
    在百度一下按钮上双击
     */
    @Test
    public void doubleClick() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement buttonBaidu=driver.findElement(By.id("su"));
        //实例化Actions
        Actions actions=new Actions(driver);
        //双击
        actions.doubleClick(buttonBaidu).perform();
        Thread.sleep(3000);
    }

    /*
    打开测试页面
    鼠标移动到action按钮
    那么显示hello world
     */
    @Test
    public void moveTest() throws InterruptedException {
        driver.get("file:///E:/xxf/xuexi/selenium_html/selenium_html/index.html");
        WebElement element=driver.findElement(By.xpath("//*[@id=\"action\"]/input"));
        //实例化Actions
        Actions actions=new Actions(driver);
        //移动到
        actions.moveToElement(element).perform();
        String  move=driver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();
        Assert.assertEquals(move,"Hello World!");
        Thread.sleep(3000);
    }

    /*
    打开测试页面
    鼠标拖动指定(x,y)
     */
    @Test
    public void dropTest() throws InterruptedException {
        driver.get("file:///E:/xxf/xuexi/selenium_html/selenium_html/dragAndDrop.html");
        WebElement element=driver.findElement(By.id("drag"));
        //实例化Actions
        Actions actions=new Actions(driver);
        //拖动到(x,y)
        actions.dragAndDropBy(element,500,500).perform();
        Thread.sleep(5000);
    }

    /*
    打开测试页面
    鼠标拖动到另一个元素上
     */
    @Test
    public void dropTest1() throws InterruptedException {
        driver.get("file:///E:/xxf/xuexi/selenium_html/selenium_html/index.html");
        WebElement element=driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        WebElement element1=driver.findElement(By.xpath("/html/body/h1"));
        //实例化Actions
        Actions actions=new Actions(driver);
        //拖动到另一个元素
        Thread.sleep(5000);
        actions.clickAndHold(element).moveToElement(element1).release();
        Thread.sleep(5000);
    }

    /*
    打开测试页面
    下拉框多选
     */
    @Test
    public void moreSelectTest() throws InterruptedException {
        driver.get("file:///E:/xxf/xuexi/selenium_html/selenium_html/index.html");
        WebElement element=driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]"));
        Actions actions=new Actions(driver);
        actions.keyDown(Keys.SHIFT).click(list.get(0)).
                click(list.get(2)).keyUp(Keys.SHIFT).perform();
        Thread.sleep(5000);
    }

    /**
     * 模拟Robot使用键盘
     */
    @Test
    public void selfTest() throws AWTException, InterruptedException {
        driver.get("http://www.baidu.com");
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        int keyS=(int)new Character('s');
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    @Test
    public  void uploadTest() throws InterruptedException {
        driver.get("file:///E:/xxf/xuexi/selenium_html/selenium_html/index.html");
        driver.findElement(By.id("load")).sendKeys("C:\\Users\\betterda\\Desktop\\11.jpg");
        Thread.sleep(3000);
    }

    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }
}
