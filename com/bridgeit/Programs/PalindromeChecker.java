package com.bridgeit.Programs;
import com.bridgeit.Utility.*;
import java.util.ArrayDeque;
import java.util.Scanner;

import com.bridgeit.Utility.Utility;

public class PalindromeChecker 
{
	public static void main(String[] args) 
	{
		Utility u = new Utility();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = scan.nextLine();
		String rev = "";
		ArrayDeque<Character> arr = new ArrayDeque<Character>();
		Utility.insertChar(str,arr);
		rev = Utility.popChar(arr,rev);
		Utility.checkPalindrom(str,rev);
		scan.close();
	}
}
