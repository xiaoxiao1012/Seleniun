package com.test4;

import com.po.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome()
    {
        System.setProperty("webdriver.chrome.driver","E:\\IDEA\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://mail.163.com");

    }

    public static void login(WebDriver driver,String email,String pwd)
    {
        driver.findElement(By.xpath("//*[@id=\"switchAccountLogin\"]")).click();
        //通过webelement方式
        WebElement iframe=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.id("dologin")).click();
    }

    //使用page类
    public static void loginPo(WebDriver driver,String email,String pwd)
    {
        driver.findElement(By.xpath("//*[@id=\"switchAccountLogin\"]")).click();
        //通过webelement方式
        WebElement iframe=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(LoginPage.emailInput).sendKeys(email);
        driver.findElement(LoginPage.passwordInput).sendKeys(pwd);
        driver.findElement(LoginPage.loginButton).click();
    }

    @Test
    public void loginSucces() throws InterruptedException {
        LoginTest.login(driver,"meyoungtester","meyoung123111");
        WebDriverWait webDriverWait=new WebDriverWait(driver,10);
        //显示等待
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"_mail_component_125_125\"]/a")));
        String logout=driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(logout,"退出");
    }

    @Test
    public void loginError() throws InterruptedException {
        LoginTest.login(driver,"meyoungtester","meyoung123");
        WebDriverWait webDriverWait=new WebDriverWait(driver,10);
        //显示等待
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));
        String error=driver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).getText();
        Assert.assertEquals(error,"帐号或密码错误");
    }


    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }
}
