package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo2 {
    //校验a==a
    @Test
    public void assertEqualTest()
    {
        String a="asdf";
        String b="asdf11";

       // Assert.assertEquals(a,b,"a不等于b");
        Assert.assertEquals(a,b);
    }

    //不等
    @Test
    public void assertNotEqualis()
    {
        int a=1;
        int b=2;
        Assert.assertNotEquals(a,b);
    }
    //空
    @Test
    public void assertNull()
    {
        String a=null;
        Assert.assertNull(a);
    }
    //不为空
    @Test
    public void assertNotNull()
    {
        String a="a";
        Assert.assertNotNull(a);
    }
}
