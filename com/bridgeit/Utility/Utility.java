package com.bridgeit.Utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.io.BufferedReader;
public class Utility 
{	
	//Anagram
	BufferedReader br;
	public Utility(){
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	/**
	 * @param primeArray
	 * @param anagarmArray
	 * @author Akash
	 * To print anagram prime numbers
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
	/**
	 * @param anagarmArray
	 * @param str
	 * @param l
	 * @param r
	 * @return ArrayList of permutation
	 */
	public static  <T> ArrayList<Integer> permute(ArrayList anagarmArray,T str, int l, int r)
	{	//if string lenth is 1
    	if (l == r)
    	{
    		anagarmArray.add(str);
    			//System.out.println(arr1);
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
	
	/**
	 * @param a
	 * @param i
	 * @param j
	 * @author Akash
	 * @return character array
	 */
	public static <T> String swap(T a, int i, int j)
	{
		char temp;
		char[] charArray = ((String) a).toCharArray();
		temp = charArray[i] ;
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
	
	/**
	 * @param primeArray
	 * @author Akash
	 * @return palindrom numbers
	 */
	public static ArrayList palindromNumber(ArrayList<Integer> primeArray)
	{
		ArrayList primenumbers = new ArrayList();
        for(Integer num :primeArray)
        {
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
	
	
	/**
	 * @param starrt
	 * @param limit
	 * @author Akash
	 * @return primenumbers
	 */
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
	
	
	/**
	 * @param str
	 * @param arr
	 */
	public static void insertChar(String str,ArrayDeque arr)
	{
		for (int i=0 ; i<str.length() ;i++ )
		{
			arr.addLast(str.charAt(i));
		}
	}
		// poping each charcter from quque from rare end and append to rev string
		/**
		 * @param arr
		 * @param rev
		 * @return
		 */
		public static String popChar(ArrayDeque<Character>arr,String rev)
		{
			while(!arr.isEmpty())
			{
				rev+=arr.removeLast();
			}
			return rev;
		}
		// checking weather string is palindrome or not
		/**
		 * @param str
		 * @param rev
		 */
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
		
		/**
		 * @param str
		 * @author Akash
		 * @return true if expression is valid else return false
		 */ 
		public static boolean checkValidExpression(String str)
		{
			int count = 0;
			Stack<Character> stk = new Stack<Character>();
			for (int i=0;i<str.length();i++)
			{
				if(str.charAt(i)=='(')
				{
					stk.push(str.charAt(i));
					count++;
				}
				
				if(str.charAt(i)==')')
				{
					if(stk.isEmpty())
					{
						count--;
					}
					else
					{
						stk.pop();
						count--;
					}
				}
			}
			if(stk.isEmpty() && count==0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		// NUMBER OF BINARY TREE
		/**
		 * @param n
		 * @author Akash
		 * @return number of binary tree
		 */
		public static long find(int n)
		{
			long sum=0;
			//if(n==0)
				//return 0;
			if(n<=1)
				return 1;
			else
			{
				
				for(int i=1;i<=n;i++)
				{
					sum = sum+(find(i-1)*find(n-i));
				}
			}
			return sum;
			
		}
		
		//CALENDER
		
		/**
		 * @param month
		 * @param day
		 * @param year
		 * @author Akash
		 * @return day of the week
		 */
		public static int dayInMonth(int month, int day, int year) 
		{
	        int y = year - (14 - month) / 12;
	        int x = y + y/4 - y/100 + y/400;
	        int m = month + 12 * ((14 - month) / 12) - 2;
	        int d = (day + x + (31*m)/12) % 7;
	        return d;
	    }

	    /**
	     * @param year
	     * @return true if year is leap year else false
	     * @author Akash
	     */
	    public static boolean isLeapYear(int year) 
	    {
	        if  ((year % 4 == 0) && (year % 100 != 0)|| year % 400 == 0) 
	        	return true;
	        else
	        	return false;
	    }
	    
		
		//ORDERED LIST
		
		/**
		 * @param list
		 * @author Akash
		 * reading data from file
		 */
		public <T> void readingDataFromFile(List<T> list)
		{
			try
			{	// reading a file from system
				File file = new File("/home/bridgeit/Akash/DataStructure/src/OrderedList");
				try
				{	// checking weather file is present or not
					if(file.exists())
					{	//checking weather read permission has or not
						if(file.canRead())
						{	//scanning file contents
							Scanner scanner = new Scanner(file);
							while (scanner.hasNext())
							{
								Integer num = scanner.nextInt();
								list.add((T) num); //storing word in linked list
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
		/**
		 * @param list
		 * @param search
		 * @author Akash
		 * searching data from file
		 */
		public <T> void searchingIntFromFile(List<T> list,T search)
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
		/**
		 * @param list
		 * @throws IOException
		 * @author Akash
		 * writting data to file
		 */
		public void writingDataToFile(List<Integer> list) throws IOException
		{
			try
			{	// reading file from system
				File file = new File("/home/bridgeit/Akash/DataStructure/src/OrderedList");
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
		/**
		 * @param arr
		 * @author Akash
		 * prints prime number in 2D array
		 */
		public <T> void print2DArray(ArrayList<T> arr)
		{
			int[][] arr1=new int[10][25];
			int res=0;
			int i=0;
			int j=0;
			Iterator<Integer> iterator=(Iterator<Integer>) arr.iterator();
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
		
		/**
		 * @param list
		 * @author Akash
		 * reads data from file
		 */
		public static <T> void readDataFromFile(List<T> list)
		{
			try
			{	// reading a file from system
				File file = new File("/home/bridgeit/Akash/DataStructure/src/UnorderedList");
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
								list.add((T) word); //storing word in linked list
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
		/**
		 * @param list
		 * @param search
		 * search word from file
		 */
		public <T> void searchingWordFromFile(List<T> list,String search)
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
				list.add((T) search);
				System.out.println(list);
			}
		}
		// Writing list back to the file 
		/**
		 * @param list
		 * @throws IOException
		 * writting data to file
		 */
		public <T> void writeDataToFile(List<T> list) throws IOException
		{
			try
			{	// reading file from system
				File file = new File("/home/bridgeit/Akash/DataStructure/src/UnorderedList");
				if(file.exists()) // checking it present or not
				{
					if(file.canWrite()) // checking weather write permission has or no
					{
						FileWriter fw = new FileWriter(file);
						BufferedWriter bw = new BufferedWriter(fw);
						String str = "";
						for (T ele:list)
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
		
		
		//Banking Cash
		
		/**
		 * @return balance
		 * @author Akash
		 * 
		 */
		public int inputInteger(){
			try{
				try{	
					return Integer.parseInt(br.readLine());
				}
				catch(NumberFormatException nfe){
					System.out.println(nfe.getMessage());	
				}
			}catch(IOException ioe){
				System.out.println(ioe.getMessage());
			}
			return 0;
		}
}
