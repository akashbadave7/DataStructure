package com.bridgeit.Programs;
import java.util.Scanner;
import java.util.Stack;
import com.bridgeit.Utility.*;
public class BalancedParentheses 
{
	public static void main(String[] args) 
	{
		Utility u = new Utility(); 
		// reading the input from keyboard
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter arithmatic expression");
		String str = scan.nextLine(); // reading expression
		u.checkValidExpression(str);
		scan.close();
	}
}
