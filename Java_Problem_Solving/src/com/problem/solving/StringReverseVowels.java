package com.problem.solving;

public class StringReverseVowels {
    public static void main(String args[]) {
	String in = "Apple a day keeps doctor away";
	String out="";
	in = new StringBuffer(in).reverse().toString().toLowerCase();
	String vow = "aeiou";
	for(int i=0; i < in.length();i++) {
	    if(vow.lastIndexOf(in.charAt(i)) != -1) {
		out += in.charAt(i);
	    }
	}
	
	System.out.println(out);
    }
}
