/*Lab 2 - This is a lab to create a clock program that runs and functions
 * Created by: Gabe Imlay
 * Sep 3, 2021*/

import java.util.*;

public class Clock
{
	private int hour, min, sec;
	
	public Clock (int myHour, int myMin, int mySec)
	{
	hour = myHour;
	min = myMin;
	sec = mySec;
	}//End Clock(args) constructor
	//-------------------------------------------------
	public Clock ()
	{
	hour = 0;
	min = 0;
	sec = 0;
	}//End Clock() constructor
	//-------------------------------------------------

	public void reset ()
	{
	hour = 0;
	min = 0;
	sec = 0;
	}//End reset() method
	//-------------------------------------------------

	public void reset (int myHour, int myMin, int mySec)
	{
	hour = myHour;
	min = myMin;
	sec = mySec;
	}//End overloaded reset() method
	//-------------------------------------------------

	public void advance ()
	//Advances the clock by one second. If the seconds has now reached 60, reset to 0, and increment the minutes. If, after incrementing minutes, 
	//minutes has now reached 60, reset minutes to 0, and increment hours. If after incrementing hours, hours has now reached 24, reset to 0.
	{
	sec++;
	if (sec>59)
	{
	min++;
		if (min>59)
		{
		min=0;
		hour++;
			if (hour>23)
			{
			hour = 0;
			}//End reset hours
		}//End reset minutes
	sec=0;
	}//End reset seconds
	System.out.println("Advancing the time!");
	System.out.println();
	}//End advance()
	//-------------------------------------------------

	public String toString()
	{
	String time = "";
	if (hour<10){
	time+="0";
        }
	time+=hour+":";

	if (min<10){
	time+="0";
	}
	time+=min+":";
	
	if (sec<10){
	time+="0";
	}
	time+=sec;
	
	return time;
	}//End toString()
//Test

}//End Clock class


