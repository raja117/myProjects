package com.problem.solving;

import java.util.Arrays;

public class RemoveDuplicate {

public static void removeDuplicte(int ...x){
	int size = x.length;
	Arrays.sort(x);
	
	for(int i = 0; i< size; i++)
	{
		for(int j = i+1; j<size; j++ )
		{
			if(x[i] == x[j])
			{
				x[j] = x[size-1];
				x[size-1] = x[i];
				size--;
			}
		}
	}
	int ar2[] = Arrays.copyOf(x, size);
	for(int k = 0;k <ar2.length;k++)
	{
		System.out.println(ar2[k]);
	}
}

public static void main(String args[])
{
	RemoveDuplicate.removeDuplicte(1,3,6,8,3,1,3,9,1);
}
}
