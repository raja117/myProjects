package com.pig.latin;

import java.util.Scanner;

public class PigLatin {

	private static String pigLatin="";
	public static String pigLatin(String s)
	{
		for(String s1 : s.split(" "))
		{
			String s2 = s1.toUpperCase();
			if(isVowel(s2.charAt(0)))
			{
				pigLatin += (s2+"way ");
				//System.out.println(pigLatin);
				continue;
			}
			else
			{
				for(char c : s2.toCharArray())
				{
					if(!isVowel(c))
					{
						s2 =  s2.substring(1, s2.length())+s2.charAt(0);
					}
					else{
						
						break;
					}
				}
				pigLatin += (s2+"ay ");
			}
		}
		return pigLatin;
	}
	
	public static boolean isVowel(char c)
	{
		if(c =='A'||c == 'E'||c == 'I'||c == 'O'||c == 'U')
		{
			return true;
		}
		return false;
	}
	
	public static void main(String atgs[])
	{
		Scanner sc = new Scanner(System.in);
		do{
			System.out.print("Enter your sentence to convert to pig latin : ");
			String str = sc.nextLine();
			String result = PigLatin.pigLatin(str);
			System.out.print("In Pig Latin : "+result+ "\n");
			System.out.print("Would you like more pig latin ? (y/n) : ");
			String yorn = sc.next();
			if(yorn.charAt(0) == 'n')
			{
				System.out.println("Thank You, Bye !!");
				sc.close();
				System.exit(0);
			}
			else{
				if(sc.hasNextLine())
				{
					str = sc.nextLine();
				}
				continue;
			}
		}while(true);
	}
}