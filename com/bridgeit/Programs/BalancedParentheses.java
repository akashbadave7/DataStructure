package com.bridgeit.Programs;
import java.util.Scanner;
import java.util.Stack;
import com.bridgeit.Utility.*;
public class BalancedParentheses 
{
	public static void main(String[] args) 
	{
		Utility utility = new Utility(); 
		// reading the input from keyboard
		Scanner scanner = new Scanner(System.in);
		boolean result=false;
		System.out.println("Enter arithmatic expression");
		String str = scanner.nextLine(); // reading expression
		if(str.length()==0) 
		{
			System.out.println("Plz.. Enter the expression.");
		}
		else
		{	// function to check for valid expression
			result = Utility.checkValidExpression(str);
			if(result == true) 
			{
				System.out.println("True!! It is valid expression.");
			}
			else
			{
				System.out.println("False!! it is not valid expression");
			
			}
		}
		scanner.close();
	}
}
