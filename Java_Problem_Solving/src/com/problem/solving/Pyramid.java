package com.problem.solving;

public class Pyramid {
	static String str = "";

	public static void main(String args[])
	{
		for(int i= 0 ; i < 5 ; i++)
		{
			for(int j = 5-i;j>0;j--)
			{
				System.out.print(" ");
			}
			str = str+"**";
			System.out.println(str);
		}
	}
}
