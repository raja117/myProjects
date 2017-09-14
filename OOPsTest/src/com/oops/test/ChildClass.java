package com.oops.test;

import javax.management.remote.SubjectDelegationPermission;

public class ChildClass extends ParentClass{
    
    public int sub(int a , int b)
    {
	int c = a -b;
	return c;
    }
    
    public ChildClass() {
	super();
	System.out.println(super.calculate(2, 3));
    }
    
    @Override
    public int calculate(int a , int b)
    {
	int c = (int) Math.pow(2, 3);
	return c;
    }
    
    public static void  main(String args[])
    {
	//ParentClass pc = new ParentClass();
	ChildClass cc = new ChildClass();
	System.out.println(cc.add(1, 2));
	System.out.println(cc.sub(3, 1));
	System.out.println(cc.calculate(2, 3));
    }
}