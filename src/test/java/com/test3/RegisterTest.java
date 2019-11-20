package com.test3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome()
    {
        System.setProperty("webdriver.chrome.driver","E:\\IDEA\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://mail.163.com");
    }

    /*
    注册
     */
    @Test
    public void registerTest() {
        //点击注册按钮
        driver.findElement(By.xpath("//*[@id=\"commonOperation\"]/a[2]")).click();
        //获取当前的driver所在的handle值
        String h1=driver.getWindowHandle();
        for (String handles:driver.getWindowHandles())
        {
            if(handles.equals(h1))
            {
                continue;
            }
            driver.switchTo().window(handles);
        }

        String time=String.valueOf(System.currentTimeMillis());

        driver.findElement(By.id("nameIpt")).sendKeys("xiaoxi123ao");
        driver.findElement(By.id("mainPwdIpt")).sendKeys("xxxx11111");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("xxxx11111");
        driver.findElement(By.id("vcodeIpt")).sendKeys("123123");
        driver.findElement(By.id("mainMobileIpt")).sendKeys("123123");
        driver.findElement(By.id("mainAcceptIpt")).click();
        driver.findElement(By.id("mainRegA")).click();

        //实例化显示等待
        WebDriverWait webDriverWait=new WebDriverWait(driver,10);
        //显示等待
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"m_mainMobile\"]/span")));

        String error=driver.findElement(By.xpath("//*[@id=\"m_mainMobile\"]/span")).getText();
        Assert.assertEquals(error,"  请填写正确的手机号");

    }

    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }

}
