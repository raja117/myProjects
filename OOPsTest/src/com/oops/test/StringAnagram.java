package com.oops.test;

import java.util.Arrays;

public class StringAnagram {
    
    public int makingAnagram(String a, String b)
    {
	int result = 0;
	for(int i = 0; i<b.length(); i++)
	{
	    if((Arrays.asList(a.toCharArray())).contains(b.charAt(i)))
	    {
		
	    }
	}
	System.out.println(result);
	return result;
    }

    public static void main(String args[])
    {
	StringAnagram sa = new StringAnagram();
	sa.makingAnagram("abc", "cde");
    }
}
