package com.problem.solving;

public class SentenseReverse {
    public static void main(String args[])
    {
	String s = "Alice likes Bob";
	String sar[] = s.split(" ");
	s = "";
	for(int i = sar.length-1 ; i>=0; i--) {
	    s = s +sar[i]+" ";
	}
	
	System.out.println(s.trim());
    }
}
