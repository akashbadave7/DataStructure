package com.bridgeit.Programs;
import java.util.ArrayList;
import java.util.Iterator;
import com.bridgeit.Utility.*;

class PrimeNumber
{
	public static void main(String[] args) 
	{
		Utility u = new Utility();
		
		ArrayList<Integer> arr = u.primeNumbers(0,1000);
		u.print2DArray(arr);
	}
}
