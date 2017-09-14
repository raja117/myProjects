package com.oops.test;

import java.util.*;

public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public Solution(String magazine, String note) {
	magazineMap = new HashMap<String, Integer>();
	noteMap = new HashMap<String, Integer>();
	magazineMap.put(magazine, magazine.length());
	noteMap.put(note, note.length());
    }

    public boolean solve() {
	String magazine = null;
	String note = null;
	for(Map.Entry<String, Integer> entry : magazineMap.entrySet())
	{
	    magazine = entry.getKey();
	}
	for(Map.Entry<String, Integer> entry : noteMap.entrySet())
	{
	    note = entry.getKey();
	}
	List<String> magazineList = new LinkedList<String>(Arrays.asList(magazine.split(" ")));
	for(String s : note.split(" "))
	{
	    if(magazineList.contains(s))
	    {
		magazineList.remove(s);
	    }
	    else{
		return false;
	    }
	}
	
	return true;
    }

    public static void main(String[] args) {
	// Scanner scanner = new Scanner(System.in);
	// int m = scanner.nextInt();
	// int n = scanner.nextInt();
	//
	// // Eat whitespace to beginning of next line
	// scanner.nextLine();

	Solution s = new Solution("give me one grand today night", "give one grand today");
	// scanner.close();

	boolean answer = s.solve();
	if (answer)
	    System.out.println("Yes");
	else
	    System.out.println("No");

    }
}
