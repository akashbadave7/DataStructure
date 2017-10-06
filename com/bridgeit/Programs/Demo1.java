package com.bridgeit.Programs;

import java.util.Arrays;

import com.bridgeit.Utility.*;

public class Demo1 {

	public static void main(String[] args) 
	{

		Utility utility = new Utility();	//	utility object
		//	prime numbers array between 0 and 1000
		String[] primeNumbers = prime(1000);

		System.out.println("Anagram and prime numbers are:");
		//	prints prime numbers that are anagrams
		for(int i = 0; i < primeNumbers.length; i++) 
		{
			for(int j = i + 1; j < primeNumbers.length; j++) {
				if(anagram(primeNumbers[i], primeNumbers[j])) {
					System.out.println(primeNumbers[i] + " " + primeNumbers[j]);
				}
			}
		}


	}

	private static String[] prime(int limit) 
	{
		String[] array = new String [1000];
		int position = 0;
		for (int i=2;i<=limit;i++)
		{
			boolean isPrime= true;
			for(int j=2;j<=i/2;j++)
			{
				if((i%j)==0)
				{
					isPrime=false;
					break;
				}
			}
			if(isPrime)
			{
				array[position]=String.valueOf(i);
				position++;
			}
		}
		String[] array1 = new String[position];
		for (int i=0;i<position;i++)
		{
			array1[i]=array[i];
		}
		return array1;
		
	}


	public static boolean anagram(String string1, String string2) 
	{
		if(string1.length() != string2.length()) {
			return false;
		}
		char[] array1 = string1.toCharArray();
		Arrays.sort(array1);
		char[] array2 = string2.toCharArray();
		Arrays.sort(array2);

		for(int i = 0; i < array1.length; i++) {
			if(array1[i] != array2[i]) {
				return false;
			}
		}
		return true;
	}
}