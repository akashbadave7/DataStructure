package com.bridgeit.Programs;
import java.util.Hashtable;
import java.util.Scanner;
import com.bridgeit.Utility.*;
public class HashingFunction
{
	@SuppressWarnings("static-access")
	public static void main(String[] args)
	{
		try
		{
			Utility u = new Utility();
			Scanner scan = new Scanner(System.in);
			// creating linked list
			@SuppressWarnings("rawtypes")
			Hashtable ht = new Hashtable(); 
			u.readingDataFromFile(ht);
			System.out.println("Enter the word to be search:");
			int search = scan.nextInt();
			u.searchingNumFromFile(ht,search);
			u.writingDataToFile(ht);
			scan.close();
		}
		catch(Exception ex)
		{
			System.out.println("The Exception is raised");
		}
	}
}
