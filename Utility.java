package com.bridgeit.Utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Utility 
{	
	//Anagram
	public static void print2DAnagramArray(ArrayList<Integer> arr)
	{
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
		int[][] arr1=new int[10][25];
		int res=0;
		int i=0;
		int j=0;
		Iterator<Integer> iterator=anagram.iterator();
		while(iterator.hasNext())
		{
			int ele = iterator.next();
			int l= ele/100;
			if(l!=res)
			{
				res=l;
				i++;
				j=0;
			}
			arr1[i][j++]=ele;
		}
		
		for(int m=0;m<arr1.length;m++)
	    {
	    	for (int n=0;n<arr1[m].length;n++)
	    	{
	    		if(arr1[m][n]==0)
	    		{
	    			System.out.print(" ");
	    		}
	    		else
	    		{
	    			System.out.print(arr1[m][n]+" ");
	    		}
	    	}
	    	System.out.println();
	    }
	}
	public static ArrayList<Integer> primeNumbers(int starrt, int limit)
	{
			ArrayList<Integer> primeNumbersList=new ArrayList<Integer>();
			for (int i=2;i<=limit;i++)
			{
				boolean prime = true;
				for(int j=2;j<i;j++)
				{
					if(i%j==0)
					{
						prime=false;
						break;
					}
				}
				if(prime==true)
				{
					primeNumbersList.add(i);
				}
			}
			return primeNumbersList;
		}
	
	
	public static void insertChar(String str,ArrayDeque<Character> arr)
	{
		for (int i=0 ; i<str.length() ;i++ )
		{
			arr.addLast(str.charAt(i));
		}
	}
		// poping each charcter from quque from rare end and append to rev string
		public static String popChar(ArrayDeque<Character>arr,String rev)
		{
			while(!arr.isEmpty())
			{
				rev+=arr.removeLast();
			}
			return rev;
		}
		// checking weather string is palindrome or not
		public static void checkPalindrom(String str,String rev)
		{
			if(str.equals(rev))
			{
				System.out.println("Given string is palindrome.");
			}
			else
			{
				System.out.println("Given string is not palindome");
			}
		}
	
		//BALANCED PARENTHESIS
		
		public static void checkValidExpression(String str) 
		{
			boolean result=false;
			if(str.length()==0) 
			{
				System.out.println("Plz.. Enter the expression.");
			}
			else
			{	// function to check for valid expression
				result = checkExpression(str);
				if(result == true) 
				{
					System.out.println("True!! It is valid expression.");
				}
				else
				{
					System.out.println("False!! it is not valid expression");
				}
			}
		}
		static boolean checkExpression(String str)
		{	// creating a stack
			Stack<Character> stk = new Stack<Character>();
			// checking for valid expression
			for (int i=0 ; i<str.length() ; i++)
			{
				if(str.charAt(i)=='(')
				{
					stk.push(str.charAt(i));
				}
				if(str.charAt(i)==')')
				{
					stk.pop();
				}
			}
		
			if(stk.isEmpty())
			{
				return true; // return true if valid
			}
			else
			{
				return false; // return false if not valid
			}
		}
		
		// NUMBER OF BINARY TREE
		public static long find(int n)
		{
			String t1 = fact(2*n);
			String t2 = fact(n+1);
			String t3 = fact(n);
			long count1 = Long.parseLong(t1)/(Long.parseLong(t2)*Long.parseLong(t3));
			return count1;
		}
		public static String fact(int n) 
		{
		       BigInteger fact = new BigInteger("1");
		       for (int i = 1; i <= n; i++) 
		       {
		           fact = fact.multiply(new BigInteger(i + ""));
		       }
		       return fact.toString();
		 }
		
		//CALENDER
		
		public static int dayInMonth(int month, int day, int year) 
		{
	        int y = year - (14 - month) / 12;
	        int x = y + y/4 - y/100 + y/400;
	        int m = month + 12 * ((14 - month) / 12) - 2;
	        int d = (day + x + (31*m)/12) % 7;
	        return d;
	    }

	    public static boolean isLeapYear(int year) 
	    {
	        if  ((year % 4 == 0) && (year % 100 != 0)|| year % 400 == 0) 
	        	return true;
	        else
	        	return false;
	    }
	    
	    
	    
	    //HASHING PROGRAM
	    
	    static int hashKey(int ele)
		{
			int rem = ele%11;
			return rem;
		}
		
		public static void readingDataFromFile(Hashtable ht)
		{
			try
			{	// reading a file from system
				File file = new File("D:/Akash/DataStructure/src/HashingData");
				try
				{	// checking weather file is present or not
					if(file.exists())
					{	//checking weather read permission has or not
						if(file.canRead())
						{	//scanning file contents
							Scanner scanner = new Scanner(file);
							while (scanner.hasNext())
							{
								int num = scanner.nextInt();
								int key = hashKey(num);
								ht.put(key, num); //storing word in linked list
							}
							System.out.println(ht);
							scanner.close();
						}
						else
						{
							System.out.println("You can't read file");
						}
					}
					else
					{
						System.out.println("File does not exits.");
					}
				}
				catch(Exception FileNotFoundException)
				{
					System.out.println("File does not exits.");
				}
			}
			catch(Exception e)
			{
				System.out.println("Esxception raised");
			}
			System.out.println();
		}
		
		public static void searchingNumFromFile(Hashtable ht,int search)
		{
			if(ht.contains(search))
			{	// word found
				System.out.println("Word found in the list and it is deleted from list.");
				int key = hashKey(search);
				ht.remove(key);
				System.out.println(ht);
			}
			else
			{	// word not found
				System.out.println("Word not found in the list and it is added to list.");
				int key = hashKey(search);
				if(ht.containsKey(key))
				{
					int newkey = rehash(key);
					ht.put(newkey, search);
					System.out.println(ht);
				}
				else
				{
					ht.put(key, search);
					System.out.println(ht);
				}
			}
		}
		static int rehash(int key) 
		{
			int newkey = (key+1)%11;
			return newkey;
		}
		
		public void writingDataToFile(Hashtable ht) throws IOException
		{
			try
			{	// reading file from system
				File file = new File("D:/Akash/DataStructure/src/HashingData");
				if(file.exists()) // checking it present or not
				{
					if(file.canWrite()) // checking weather write permission has or no
					{
						FileWriter fw = new FileWriter(file);
						BufferedWriter bw = new BufferedWriter(fw);
						String str = "";
						for (Object obj: ht.keySet())
						{
							str+=ht.get(obj)+" ";
						}
						bw.write(str);
						bw.flush();
						bw.close();
					}
					
					else
					{
						System.out.println("You cant edit the file!!. Its does not have edit permission.");
					}
				}
				else
				{
					System.out.println("File not exits.");
					return ;
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception raised");
			}
		}
		
		//ORDERED LIST
		
		public  void readingDataFromFile(List<Integer> list)
		{
			try
			{	// reading a file from system
				File file = new File("D:/Akash/DataStructure/src/OrderedList");
				try
				{	// checking weather file is present or not
					if(file.exists())
					{	//checking weather read permission has or not
						if(file.canRead())
						{	//scanning file contents
							Scanner scanner = new Scanner(file);
							while (scanner.hasNext())
							{
								int num = scanner.nextInt();
								list.add(num); //storing word in linked list
								list.sort(null);
							}
							System.out.println(list);
							scanner.close();
						}
						else
						{
							System.out.println("You can't read file");
						}
					}
					else
					{
						System.out.println("File does not exits.");
					}
				}
				catch(Exception FileNotFoundException)
				{
					System.out.println("File does not exits.");
				}
			}
			catch(Exception e)
			{
				System.out.println("Esxception raised");
			}
			System.out.println();
		}
		
		/* 	searching the word in file
		*	if word presents in list removes the word from list and write back to file
		*	if word not present in the list then add the word to list and write back to the file
		*/
		public  void searchingIntFromFile(List<Integer> list,int search)
		{
			if(list.contains(search))
			{	// Integer found
				System.out.println("Integer found in the list and it is deleted from list.");
				list.remove((Integer)search);
				list.sort(null);
				System.out.println(list);
			}
			else
			{	// Integer not found
				System.out.println("Integer not found in the list and it is added to list.");
				list.add(search);
				list.sort(null);
				System.out.println(list);
			}
		}
		// Writing list back to the file 
		public void writingDataToFile(List<Integer> list) throws IOException
		{
			try
			{	// reading file from system
				File file = new File("D:/Akash/DataStructure/src/OrderedList");
				if(file.exists()) // checking it present or not
				{
					if(file.canWrite()) // checking weather write permission has or no
					{
						FileWriter fw = new FileWriter(file);
						BufferedWriter bw = new BufferedWriter(fw);
						String str = "";
						for (int ele:list)
						{
							str+=ele+" ";
						}
						bw.write(str);
						bw.flush();
						bw.close();
					}
					
					else
					{
						System.out.println("You cant edit the file!!. Its does not have edit permission.");
					}
				}
				else
				{
					System.out.println("File not exits.");
					return ;
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception raised");
			}
		}
		
		// PrimeNumberToPrintIn2DArray
		public void print2DArray(ArrayList<Integer> arr)
		{
			int[][] arr1=new int[10][25];
			int res=0;
			int i=0;
			int j=0;
			Iterator<Integer> iterator=arr.iterator();
			while(iterator.hasNext())
			{
				int ele = iterator.next();
				int l= ele/100;
				if(l!=res)
				{
					res=l;
					i++;
					j=0;
				}
				arr1[i][j++]=ele;
			}
		    for(int m=0;m<arr1.length;m++)
		    {
		    	for (int n=0;n<arr1[m].length;n++)
		    	{
		    		if(arr1[m][n]==0)
		    		{
		    			System.out.print(" ");
		    		}
		    		else
		    		{
		    			System.out.print(arr1[m][n]+" ");
		    		}
		    	}
		    	System.out.println();
		    }
		}
		
		
		//UnorderdListForString
		
		public static void readDataFromFile(List<String> list)
		{
			try
			{	// reading a file from system
				File file = new File("D:/Akash/DataStructure/src/UnorderedList");
				try
				{	// checking weather file is present or not
					if(file.exists())
					{	//checking weather read permission has or not
						if(file.canRead())
						{	//scanning file contents
							Scanner scanner = new Scanner(file);
							while (scanner.hasNext())
							{
								String word = scanner.next();
								System.out.print(word+" ");
								list.add(word); //storing word in linked list
							}
							scanner.close();
						}
						else
						{
							System.out.println("You can't read file");
						}
					}
					else
					{
						System.out.println("File does not exits.");
					}
				}
				catch(Exception FileNotFoundException)
				{
					System.out.println("File does not exits.");
				}
			}
			catch(Exception e)
			{
				System.out.println("Esxception raised");
			}
			System.out.println();
		}
		
		/* 	searching the word in file
		*	if word presents in list removes the word from list and write back to file
		*	if word not present in the list then add the word to list and write back to the file
		*/
		public void searchingWordFromFile(List<String> list,String search)
		{
			if(list.contains(search))
			{	// word found
				System.out.println("Word found in the list and it is deleted from list.");
				list.remove(search);
				System.out.println(list);
			}
			else
			{	// word not found
				System.out.println("Word not found in the list and it is added to list.");
				list.add(search);
				System.out.println(list);
			}
		}
		// Writing list back to the file 
		public void writeDataToFile(List<String> list) throws IOException
		{
			try
			{	// reading file from system
				File file = new File("D:/Akash/DataStructure/src/UnorderedList");
				if(file.exists()) // checking it present or not
				{
					if(file.canWrite()) // checking weather write permission has or no
					{
						FileWriter fw = new FileWriter(file);
						BufferedWriter bw = new BufferedWriter(fw);
						String str = "";
						for (String ele:list)
						{
							str+=ele+" ";
						}
						bw.write(str);
						bw.flush();
						bw.close();
					}
					else
					{
						System.out.println("You cant edit the file!!. Its does not have edit permission.");
					}
				}
				else
				{
					System.out.println("File not exits.");
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception raised");
			}
		}
}
