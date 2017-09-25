package com.bridgeit.Programs;
import java.util.Scanner;
import com.bridgeit.Utility.*;
class Calender
{
    public static void main(String[] args) 
    {	
    	Utility u = new Utility(); 
    	Scanner scan = new Scanner(System.in);
        int month = scan.nextInt();
        int year = scan.nextInt();
        String[] months = {"","January", "February", "March","April", "May", "June",
            "July", "August", "September","October", "November", "December"};

        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && u.isLeapYear(year)) 
        {
        	days[month] = 29;
        }
        System.out.println("   " + months[month] + " " + year);
        System.out.println(" S  M Tu  W Th  F  S");
        int d = u.dayInMonth(month, 1, year);
        for (int i = 0; i < d; i++)
        {
            System.out.print("   ");
        }
        for (int i = 1; i <= days[month]; i++)
        {
            System.out.printf("%2d ", i);
            if (((i + d) % 7 == 0) || (i == days[month])) 
            	System.out.println();
        }
        scan.close();
    }
}
