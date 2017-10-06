package com.bridgeit.Programs;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;

class Demo
{
	public static void main(String args[])
	{
		HashMap hm = new HashMap();
		LinkedList ll = new LinkedList();
		LinkedList ll2 = new LinkedList();
		ll.add(22);
		ll.add(33);
		ll2.add(34);
		System.out.println(ll);
		hm.put(0, ll);
		hm.put(1, ll2);
		System.out.println(hm);
		
	}
	  //HASHING PROGRAM
    
    /**
     * @param ele
     * @return
     */
    static int hashKey(int ele)
	{
		int rem = ele%11;
		return rem;
	}
	
	/**
	 * @param ht
	 */
	/**
	 * @param ht
	 */
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
	
	/**
	 * @param ht
	 * @param search
	 */
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
	/**
	 * @param key
	 * @return
	 */
	static int rehash(int key) 
	{
		int newkey = (key+1)%11;
		return newkey;
	}
	
	/**
	 * @param ht
	 * @throws IOException
	 */
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
}
