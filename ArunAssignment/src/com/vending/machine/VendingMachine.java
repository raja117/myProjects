package com.vending.machine;

import java.text.NumberFormat;
import java.util.Scanner;

public class VendingMachine {
	
	private static double half_pint = 1.59;
	private static double pint = 2.59;
	private static double quart = 3.59;
	private static double price;
	private static double savedPrice = 0;
	private static double totalPrice = 0;
	private static int quantity;
	private static int previousQuantityA = 0;
	private static int previousQuantityB = 0;
	private static int previousQuantityC = 0;
	private static int cnt;

	public static void menu()
	{
		String s ="				************************************************************************* \r\n" + 
				"				 PRICE/OZ:	Half-Pint: $0.20	Pint: $0.16	Quart: $0.11\r\n" + 
				"				*************************************************************************\r\n" + 
				"				  ***************************BUTTER BEER*******************************\r\n" + 
				"					   SIZE				 	 PRICE\r\n" + 
				"					================			=========== \r\n" + 
				"					 A. HALF_PINT				 $1.59\r\n" + 
				"					 B. PINT				 $2.59\r\n" + 
				"					 C. QUART				 $3.59 \r\n" + 
				"				  ********************************************************************";
		System.out.println(s);
	}
	
	public static double calPrice(String type)
	{
		type = type.toUpperCase();
		switch(type){
		case "A" : price = half_pint;
					break;
		case "B" : price = pint;
				    break;
		case "C" : price = quart;
					break;
		}
		return price;
	}
	
	public static double calPrice(String type, int quantity)
	{
		type = type.toUpperCase();
		switch(type){
		case "A" : price = (half_pint*quantity);
					break;
		case "B" : price = (pint*quantity);
				    break;
		case "C" : price = (quart*quantity);
					break;
		}
		return price;
	}
	
	public static double freeDrink(String type){
			switch(type.toUpperCase())
			{
			case "A" : previousQuantityA += quantity;
						if(previousQuantityA > 5)
						{
							previousQuantityA -= 6;
							cnt++;
							return half_pint;
						}
						break;
			case "B" : previousQuantityB += quantity;
						if(previousQuantityB > 5)
						{
							previousQuantityB -= 6;
							cnt++;
							return pint;
						}
						break;
			case "C" : previousQuantityC += quantity;
						if(previousQuantityC > 5)
						{
							previousQuantityC -= 6;
							cnt++;
							return quart;
						}
						break;
			}
			return 0;
	}
	
	public static void payDrinks()
	{
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		System.out.println("Total : $"+nf.format((totalPrice - savedPrice)) + " included " + cnt +" free drink(s)");
		System.out.println("you saved $"+nf.format(savedPrice));
	}
	
	public static void main(String args[])
	{
		boolean illegalQuantity= false;
		boolean illegalDrink = false;
		String type = null;
		Scanner sc = new Scanner(System.in);
		do{
			if(!illegalDrink && !illegalQuantity)
			VendingMachine.menu();
			if(!illegalQuantity){
				System.out.print("Enter Type of Drink (A,B or C) : ");
				type = sc.next();
			}
			if(type.matches("[A|B|C|a|b|c]"))
			{
				System.out.print("Enter Quantity (1-5) : ");
				quantity = sc.nextInt();
				if(!(String.valueOf(quantity).matches("[a-zA-Z]")) && !(quantity > 5))
				{
					if(quantity == 1)
					{
						totalPrice += calPrice(type); 
					}
					else if((quantity > 1) && (quantity <= 5))
					{
						totalPrice += calPrice(type,quantity);
					}
				}
				else if(quantity > 5){
					System.out.println("!! Error - Enter Only 1-5");
					illegalQuantity = true;
					continue;
				}
			}
			else{
				illegalDrink = true;
				System.out.println("**ERROR**--!! Only A, B OR C !!");
				continue;
			}
			savedPrice += freeDrink(type);
			System.out.println("Do you want more Beer (Y/N) : ");
			if(sc.next().equalsIgnoreCase("y"))
			{
				illegalQuantity= false;
				illegalDrink = false;
				continue;
			}
			else
			{
				break;
			}
		}while(true);
		payDrinks();
		sc.close();
	}
}