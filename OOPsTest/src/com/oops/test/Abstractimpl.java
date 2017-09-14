package com.oops.test;

import java.util.Scanner;

public class Abstractimpl implements AbstractDemo{

    @Override
    public void add() {
	Scanner s = new Scanner(System.in);
	System.out.println("Enter Numnber: ");
	int a = s.nextInt();
	int b = s.nextInt();
	int c = a + b;
	System.out.println(c);
    }

}
