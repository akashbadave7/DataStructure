package com.bridgeit.Programs;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import com.bridgeit.Utility.*;
 

class Stack 
{
	public static void main(String[] args) 
	{
		Utility u = new Utility();
		LinkedStack ls = new LinkedStack();  
		ArrayList<Integer> arr = u.primeNumbers(0,1000); 
		ArrayList<Integer> anagram = new ArrayList<Integer>();
		for(int ele : arr)
		{
			int temp = ele;
			int sum=0;
			while(temp!=0)
			{
				int rem = temp%10;
				sum =(sum*10)+rem;
				temp = temp/10;
			}
			if(arr.contains(sum))
			{
				anagram.add(sum);
				anagram.sort(null);
			}
		}
		for(int ele:anagram)
		{
			ls.push(ele);
		}
		ls.display();
	}

}
