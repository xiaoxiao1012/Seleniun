package com.test2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome()
    {
        System.setProperty("webdriver.chrome.driver","E:\\IDEA\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    /*多窗口
    打开测试界面
    点击open new window
    点击百度
     */
    @Test
    public void testWindow() throws InterruptedException {
        driver.get("file:///E:/xxf/xuexi/selenium_html/selenium_html/index.html");
        driver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(3000);
        //当前的driver所在页面的 句柄值
        String handlel=driver.getWindowHandle();
        //for循环判断获取到的handels是否等于hangdel1
        for(String handles:driver.getWindowHandles())
        {
            if(handles.equals(handlel))
                continue;
            driver.switchTo().window(handles);
        }
        Thread.sleep(3000);
        driver.findElement(By.linkText("baidu")).click();

    }

    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }
}
