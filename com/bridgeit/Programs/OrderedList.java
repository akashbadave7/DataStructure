package com.bridgeit.Programs;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import com.bridgeit.Utility.*;
public class OrderedList 
{
	public static void main(String[] args)
	{
		try
		{
			Utility u = new Utility();
			Scanner scan = new Scanner(System.in);
			// creating linked list
			List<Integer> list = new LinkedList<Integer>();
			u.readingDataFromFile(list);
			System.out.println("Enter the word to be search:");
			int search = scan.nextInt();
			u.searchingIntFromFile(list,search);
			u.writingDataToFile(list);
			scan.close();
		}
		catch(Exception ex)
		{
			System.out.println("The Exception is raised");
		}
	}
}
