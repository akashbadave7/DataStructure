package com.bridgeit.Programs;

import java.util.Scanner;

class Test 
{
	public static void mainTest(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number.");
		int n = scan.nextInt();
		int fact = find(n);
		System.out.println(fact);
		scan.close();
	}
	
	static int find(int N) 
	{

		  if (N <=1) { 
		    return(1); 
		  } 
		  else { 

		    // Iterate through all the values that could be the root... 
		    int sum = 0; 
		    int left, right, root;

		    for (root=1; root<=N; root++) { 
		      left = find(root - 1); 
		      right = find(N - root);

		      // number of possible trees with this root == left*right 
		      sum += left*right; 
		    }

		    return(sum); 
		  } 
		}
}