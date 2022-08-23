//TestClock program to test the Clock Class as part of Lab2
//Created by Gabe Imlay
//September 12, 2021

import java.util.*;

public class TestClock{

public static void main (String[] args)
{
	int testHour, testMin ,testSec;
	Clock dvr = new Clock();
	Scanner in = new Scanner(System.in);

	System.out.println("What time would you like to set your DVR to?");
	System.out.println();
	System.out.print("Hours = ");
	testHour = in.nextInt();
	System.out.print("Minutes = ");
	testMin = in.nextInt();
	System.out.print("Seconds = ");
	testSec = in.nextInt();
	dvr.reset(testHour, testMin, testSec);
	System.out.println();
	//Clock dvr = new Clock(testHour, testMin, testSec);
	System.out.println("The time is now "+ dvr.toString());
	System.out.println();
	dvr.advance();
	System.out.println("The time is now "+ dvr.toString());




}//End main()
}//End TestClock Class
