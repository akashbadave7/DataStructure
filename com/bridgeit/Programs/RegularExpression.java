package com.bridgeit.Programs;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RegularExpression 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String str ="Hello <<name>>, We have your full name as <<full name>> in our system."
				+ "Your contact number is 91-xxxxxxxxxx.Please,let us know in case of any "
				+ "clarification.Thank you BridgeLabz 01/01/2016.";
		DateFormat d1= new SimpleDateFormat();
		Date d = new Date();
		String[] date = (d1.format(d)).split(" ");
		System.out.println("Enter your full name:");
		String name = scan.nextLine();
		System.out.println("Enter your mobile number");
		String mob = scan.nextLine();
		String arr[] = name.split(" ");
		str = str.replace("<<name>>", arr[0]);
		str = str.replace("<<full name>>", name);
		str = str.replace("xxxxxxxxxx", mob);
		str = str.replace("01/01/2016", date[0]);
		System.out.println(str);
		scan.close();
	}
}