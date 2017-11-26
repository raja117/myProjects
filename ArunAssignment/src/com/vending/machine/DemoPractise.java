package com.vending.machine;

import java.util.Arrays;

public class DemoPractise {

    public static void main(String[] args) {
	String s = "98765421000111100";

	String a[][] = new String[11][11];
	int c = 0;
	for(int b = 9; b>=0; b--)
	{
	    a[b][1] = String.valueOf(c);
	    c++;
	}
	a[10][10] = " ";
	c=0;
	for(int b = 1; b<=9; b++ )
	{
	    a[9][b+1] = String.valueOf(c);
	    c++;
	}
	//a[1][10] = "0";
	//System.out.print(a[1][10]);
	for(int i = 1; i<=9;i++)
	{
	    int count = 0;
	    for(int j = 1 ; j < s.toCharArray().length; j++)
	    {
		if(String.valueOf(s.toCharArray()[j]).equals(String.valueOf(i))) {
		    count++;
		}
	    }
	  //  System.out.println(count);
	    a[i][count] = "*";
	}
	
	for(int i = 0; i <11 ;i++) {
	    for(int j = 0 ; j <11;j++)
	    {
		if(a[i][j] != null)
		System.out.print(a[i][j] +"  ");
	    }
	    System.out.println();
	}
	
    }

}
