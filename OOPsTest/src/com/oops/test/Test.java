package com.oops.test;

import java.lang.reflect.InvocationTargetException;
import java.security.PublicKey;

public class Test {
    
//    public static void main(String args[])
//    {
//	Abstractimpl aiompl = new Abstractimpl();
//	aiompl.add();
//    }
    
    public static void main(String rgs[]) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
	EncapDemo ed = new EncapDemo();
	Class obj = Class.forName("com.oops.test.EncapDemo");
	obj.getDeclaredMethod("getName").setAccessible(true);
    }
}
