package com.problem.solving;

public class ArraySortTest {
    
    public static boolean arrayTest(int ar[]) {
	if(ar.length <= 1) {
	    return true;
	}
	for(int i = 1 ; i < ar.length;i++)
	{
	    if(ar[i-1] > ar[i]) {
		return false;
	    }
	}
	return true;
    }
    
    public static void main(String args[])
    {
	int ar[] = {-1,0,2,2,3};
	if(arrayTest(ar)) {
	    System.out.println("Sorted");
	}
	else{
	    System.out.println("Not Sorted");
	}
    }
}
