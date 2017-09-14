package com.oops.test;

public class ArrayLeftRotation {

    public int[] arrayRotation()
    {
	int arr[] = {1,2,3,4,5};
	int n = arr.length;
	int k = 4;
	if(n > k)
	{
	    for(int  i = 0 ; i < k ; i++)
	    {
		int first = arr[0];
		for(int j = 0; j < arr.length-1; j++)
		{
		    arr[j] = arr[j+1];
		}
		arr[arr.length-1] = first;
	    }
	}
	for(int r =0 ;r < arr.length; r++)
	{
	    System.out.println(arr[r]);
	}
	return arr;
    }
    
    public static void main(String args[])
    {
	ArrayLeftRotation alr = new ArrayLeftRotation();
	alr.arrayRotation();
    }
}
