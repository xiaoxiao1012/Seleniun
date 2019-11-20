package com.test;

import org.testng.annotations.Test;

public class BT {
    @Test
    public void c()
    {
        AT at=new AT();
        at.b();
    }

    @Test
    public void d()
    {
        AT at=new AT();
        at.a();
    }
}
