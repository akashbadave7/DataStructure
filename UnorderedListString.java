package com.bridgeit.Programs;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import com.bridgeit.Utility.*;
public class UnorderedListString
{
	public static void main(String[] args)
	{
		try
		{
			Utility u = new Utility();
			Scanner scan = new Scanner(System.in);
			// creating linked list
			List<String> list = new LinkedList<String>();
			u.readDataFromFile(list);
			System.out.println("Enter the word to be search:");
			String search = scan.nextLine();
			u.searchingWordFromFile(list,search);
			u.writeDataToFile(list);
			scan.close();
		}
		catch(Exception ex)
		{
			System.out.println("The Exception is raised");
		}
	}
}
