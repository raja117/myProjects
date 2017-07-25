package com.phone.log;
		
import java.util.Scanner;

public class JavaProgram
{
    //static int num;
    String binary="";
    public String dec2bin(int num)
    {
		int rem = num%2;
		binary = String.valueOf(rem)+binary;
		num = num/2;
		if(num>0)
		{
			dec2bin(num);
		}
    	return binary;
    }
    
    public static void main(String args[])
    {
    	Scanner s = new Scanner(System.in);
    	int num = s.nextInt();
    	JavaProgram jp = new JavaProgram();
    	System.out.println(jp.dec2bin(num));
    	s.close();
    }
}