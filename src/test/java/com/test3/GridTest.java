package com.test3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {
    @Test
    public void testChrome() throws MalformedURLException, InterruptedException {
        //创建DesiredCapabilities类型
        DesiredCapabilities dc=DesiredCapabilities.chrome();
        //实例化一个driver
        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.157:4444/wd/hub"),dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.quit();
    }

    //数据驱动
        @DataProvider(name="data4")
        public Object[][] test1()
        {
            return new Object[][]{{"chrome"},{"firefox"}};
    }

    @Test(dataProvider = "data4")
    public void testGrid2(String browser) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc=null;
        if(browser.contentEquals("chrome"))
        {
            dc=DesiredCapabilities.chrome();
        }else if (browser.contentEquals("firefox")) {
            dc = DesiredCapabilities.firefox();
        }else {
            System.out.println("error");
        }
        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.157:4444/wd/hub"),dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.quit();
    }
}
