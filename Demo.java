package com.bridgeit.Programs;
import java.util.Scanner;

class Demo
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int start = s.nextInt();
		int limit = s.nextInt();
		int arr[] = new int[limit/2]; 
		int k=0,len = 0;
		// find prime number between range 
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
				arr[k]=i;
				k++;
			}
		}

        for (int i=0; i<arr.length; i++)
        {
            if (arr[i] != 0)
                len++;
        }
        // to store prime number in array
        int [] newArray = new int[len];
        for (int i=0, j=0; i<arr.length; i++)
        {
            if (arr[i] != 0) {
                newArray[j] = arr[i];
                j++;
            }
        }
        System.out.println();
        //to print prime numbers
        for(int i=0;i<newArray.length;i++)
		{
				System.out.print(newArray[i]+ " ");
		}
        System.out.println();
        //to find palindrom and anagram
        System.out.println("Anagram and palindrome prime numbers are:");
        for(int i=0;i<newArray.length;i++)
        {
        	int num = newArray[i];
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
        		System.out.print(num+" ");
        	}
        }
        s.close();
	}
}
