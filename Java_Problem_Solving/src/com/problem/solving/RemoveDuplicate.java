package com.problem.solving;

import java.util.Arrays;

public class RemoveDuplicate {

public static void removeDuplicte(){
	int ar[] = {1,1,1,2,3,4};
	int size = ar.length;
	
	for(int i = 0; i< size; i++)
	{
		for(int j = i+1; j<size; j++ )
		{
			if(ar[i] == ar[j])
			{
				ar[j] = ar[size-1];
				ar[size-1] = ar[i];
				size--;
			}
		}
	}
	int ar2[] = Arrays.copyOf(ar, size);
	for(int k = 0;k <ar2.length;k++)
	{
		System.out.println(ar2[k]);
	}
}

public static void main(String args[])
{
	RemoveDuplicate.removeDuplicte();
}
}
