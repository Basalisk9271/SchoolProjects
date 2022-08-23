import java.util.*;

public class Stats
{
	private static final int MAX_SIZE = 100;
	public static void main(String[] args)
	{
        	int[] List = new int[MAX_SIZE];		
		int numItems;

        	numItems = fillUp (List);

        	System.out.println("\n\10\7" + " The range of your " +
                                   numItems + " items is :  " + 
				   range (List, numItems));

        	System.out.println("\n\10\7" + " The mean of your " + 
                                   numItems + " items is  :  " +
				   mean (List, numItems));
	}//End Main()
	//--------------------------------------------------------------------

	public static int fillUp(int[] List)
	{
	Scanner in = new Scanner(System.in);
	int listSize = 0, index = 0;
	int input;
        do 
        {
        	input = in.nextInt();
        	if (input<100 && input> 1)
        	{
        		List[index] = input;
        		index++;
        		listSize++;
        	}//End First if
        	if (input<0)
        	{
        		System.out.println("Please input a valid integer between 1 and 100, or press 0 to halt");
        	}//End Second if
		if (input>=100)
		{
			System.out.println("Please input a valid integer between 1 and 100, or press 0 to halt");	
		}//End third if
        }while (input != 0);//End do-while
	return listSize;
         
	}//End fillUp
	//--------------------------------------------------------------------
	public static int range(int[] List, int numItems)
	{
	int min = List[0], max = List[0];
        for (int j=0; j<numItems; j++)
        {
                if (List[j]>max)
                {
                max = List[j];
                }//End max
                else if (List[j]<min)
                {
                min = List[j];
                }//End min 
        }//End For Loop
        int range = max-min;
        //System.out.println(range);
        return range;
	}//End range()

	//--------------------------------------------------------------------
	public static double mean(int[] List, int numItems)
	{
	int sum = 0;
	double avg;
	if (numItems>0)
	{
	for (int k=0; k<numItems; k++)
	{
		sum+=List[k];
	}//End For loop
	avg = (sum/numItems);
	}
	else{
	avg = 0;}
	return avg;
	}//End of Mean()	

}
