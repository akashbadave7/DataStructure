package com.bridgeit.Programs;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Node1
{
    protected Object data;
    protected Node1 link;
 
    /*  Constructor  */
    public Node1()
    {
        link = null;
        data = "0";
    }    
    /*  Constructor  */
    public Node1(Object data2,Node1 n)
    {
        data = data2;
        link = n;
    }    
    /*  Function to set link to next Node1  */
    public void setLink(Node1 n)
    {
        link = n;
    }    
    /*  Function to set data to current Node1  */
    public void setData(String d)
    {
        data = d;
    }    
    /*  Function to get link to next Node1  */
    public Node1 getLink()
    {
        return link;
    }    
    /*  Function to get data from current Node1  */
    public Object getData()
    {
        return data;
    }
}
class linkedQueue1
{
    protected Node1 front, rear;
    public int size;
 
    /* Constructor */
    public linkedQueue1()
    {
        front = null;
        rear = null;
        size = 0;
    }    
    /*  Function to check if queue is empty */
    public boolean isEmpty()
    {
        return front == null;
    }    
   
    /*  Function to insert an element to the queue */
    public void insert(Object data)
    {
        Node1 nptr = new Node1(data, null);
        if (rear == null)
        {
            front = nptr;
            rear = nptr;
        }
        else
        {
            rear.setLink(nptr);
            rear = rear.getLink();
        }
        size++ ;
    }    
    /*  Function to remove front element from the queue */
    public Object remove()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        Node1 ptr = front;
        front = ptr.getLink();        
        if (front == null)
            rear = null;
        size-- ;        
        return ptr.getData();
    }    
    
    /*  Function to display the status of the queue */
    public void display()
    {
        System.out.print("\nQueue = ");
        if (size == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        Node1 ptr = front;
        while (ptr != rear.getLink() )
        {
            System.out.print(ptr.getData()+" ");
            ptr = ptr.getLink();
        }
        System.out.println();        
    }
}
public class CalenderQueue {

	public static void main(String[] args) 
	{
		linkedQueue1 month = new linkedQueue1();
		linkedQueue1 day = new linkedQueue1();
		Scanner scan = new Scanner(System.in);
        String[] months = {"","January", "February", "March","April", "May", "June",
            "July", "August", "September","October", "November", "December"};
        for(int i=0; i<months.length;i++)
        {
        	month.insert(months[i]);
        }
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for(int i=0;i<days.length;i++)
        {
        	day.insert(days[i]);
        }
    	int mon = scan.nextInt();
        int year = scan.nextInt();
        if (mon == 2 && isLeapYear(year)) 
        {
        	days[mon] = 29;
        }
        System.out.println("   " + months[mon] + " " + year);
        System.out.println(" S  M Tu  W Th  F  S");
        int d = dayInMonth(mon, 1, year);
        for (int i = 0; i < d; i++)
        {
            System.out.print("   ");
        }
        for (int i = 1; i <= days[mon]; i++)
        {
            System.out.printf("%2d ", i);
            if (((i + d) % 7 == 0) || (i == days[mon])) 
            	System.out.println();
        }
        scan.close();
        
	}
	
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

}
