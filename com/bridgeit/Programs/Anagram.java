package com.bridgeit.Programs;
import com.bridgeit.Utility.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import com.bridgeit.Utility.*;
class Anagram
{
	public static void main(String[] args) 
	{
		try{
			Utility u = new Utility();
			ArrayList<Integer> primeArray = u.primeNumbers(0, 1000);
			ArrayList<Integer> anagarmArray = new ArrayList<Integer>(); 

			
			@SuppressWarnings("unchecked")
			ArrayList<Integer> primenumbers = u.palindromNumber(primeArray);
			System.out.println();
			anagarmArray = findAnagram(primeArray,anagarmArray,primenumbers);
			//printArrayElement(primeArray,anagarmArray);
			u.printArrayElement(primeArray, anagarmArray);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static ArrayList<Integer> findAnagram(ArrayList<Integer> primeArray, ArrayList<Integer> anagarmArray, ArrayList<Integer> primenumbers) 
	{
		System.out.println("Anagram numbers");
		for (Integer ele : primeArray)
		{
			String str = Integer.toString(ele);
			int l = str.length(); 
			anagarmArray=permute(anagarmArray,str,0,l-1);
		}
		for (Integer ele : primeArray)
		{	
			String str = Integer.toString(ele);
			if(anagarmArray.contains(str))
			{
				anagarmArray.remove(str);
			}
		}
		
		for (Integer ele : primenumbers)
		{	
			String str = Integer.toString(ele);
			if(anagarmArray.contains(str))
			{
				anagarmArray.remove(str);
			}
		}
		return anagarmArray;
	}

	/**
	 * @param primeArray
	 * @param anagarmArray
	 * @author akash
	 */
	public static void printArrayElement(ArrayList<Integer> primeArray, ArrayList<Integer> anagarmArray) 
	{
		ArrayList<Integer> anagram = new ArrayList<Integer>();
		
		for (Integer ele : primeArray)
		{	
			String str = Integer.toString(ele);
			if(anagarmArray.contains(str))
			{
				anagram.add(Integer.parseInt((String)str));
			}
		}
		for(Integer ele : anagram)
		{
			System.out.print(ele+" ");
		}
		
	}
	
	public static  <T> ArrayList<Integer> permute(ArrayList anagarmArray,T str, int l, int r)
	{	//if string lenth is 1
    	if (l == r)
    	{
    		anagarmArray.add(str);
    	}
    	else
    	{	
    		for (int i = l; i <= r; i++)
    		{
        		str = (T) swap(str,l,i);
        		permute(anagarmArray, str, l+1, r);
        		str = (T) swap(str,l,i);
    		}
    	}
		return anagarmArray;
    	
	}

	// function to swap charactor in string
	
	public static <T> String swap(T a, int i, int j)
	{
		char temp;
		char[] charArray = ((String) a).toCharArray();
		temp = charArray[i] ;
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	public static ArrayList palindromNumber(Integer[] array)
	{
		ArrayList primenumbers = new ArrayList();
		System.out.println("palindrome prime numbers are:");
        for(int i=0;i<array.length;i++)
        {
        	int num = array[i];
        	int temp = num;
        	int sum=0;
        	while (temp!=0)
        	{
        		int rem = temp%10;
        		sum = (sum*10)+rem;
        		temp = temp/10;
        	}
        	if (num == sum)
        	{
        		primenumbers.add(num);
        	}
        }
		return primenumbers;
	}
}
