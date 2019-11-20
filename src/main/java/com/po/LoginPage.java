package com.po;

import org.openqa.selenium.By;

public class LoginPage {
    //定义email文本框的定位方式
    public static By emailInput=By.name("email");
    //定义密码文本框的定位方式
    public static By passwordInput=By.name("password");
    //定义登录按钮的定位方式
    public static By loginButton=By.id("dologin");
}
