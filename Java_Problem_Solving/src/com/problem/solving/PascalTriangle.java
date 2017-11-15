package com.problem.solving;

public class PascalTriangle {
    
    public static void main(String args[]) {
	int[] previousRow;
	int[] currentRow = {1};
	printArray(currentRow);
	previousRow = currentRow;
	for(int i = 2; i<=6; i++)
	{
	    currentRow = new int[i];
	    currentRow[0] = 1;
	    currentRow[i-1] = 1;
	    for(int j = 0; j <=i-3; j++)
	    {
		currentRow[j+1] = previousRow[j] + previousRow[j+1];
	    }
	    printArray(currentRow);
	    previousRow = currentRow;
	}
	System.out.println();
    }
    
    public static void printArray(int[] ar) {
	for(int i = 0; i < ar.length; i++)
	{
	    System.out.print(ar[i]+" ");
	}
	System.out.println();
    }
}