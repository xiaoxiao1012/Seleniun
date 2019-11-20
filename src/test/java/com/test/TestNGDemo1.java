package com.test;

import org.testng.annotations.*;

public class TestNGDemo1 {
    @BeforeClass
    public void beforeTest1()
    {
        System.out.println("这是@BeforeClass注解");
    }
    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("这是@BeforeMethod注解");
    }
    @Test
    public void testCase1()
    {
        System.out.println("这是@Test注解，case1");
    }
    @Test
    public void testCast2() {
        System.out.println("这是@Test注解，case2");
    }
    @AfterClass
    public void afterTest1()
    {
        System.out.println("这是@AfterClass注解");
    }
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("这是@AfterMethod注解");
    }


}
