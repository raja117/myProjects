package com.oops.test;

public class ParentClass {
    
    public String Name;
    
    public String age;
    
    public int add(int a, int b)
    {
	int c = a +b;
	return c;
    }
    
    public int add(int a, int b, int c)
    {
	int d = a + b + c;
	return d;
    }
    
    public static void main(String args[])
    {
	ParentClass pc = new ParentClass();
	pc.add(1, 2,5);
    }
    
    public int calculate(int a, int b)
    {
	int c = a * b;
	return c;
    }
}