
import java.util.*;

@SuppressWarnings("unchecked")
public class JCFQueue
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		LinkedList queue1 = new LinkedList();
		LinkedList queue2 = new LinkedList();
		Object key = new Character('$');

        	queue1.addLast(new Character('b'));
        	queue1.addLast(new Character('$'));
        	queue1.addLast(new Character('E'));
        	queue1.addLast(new Character('$'));
        	queue2.addLast(new Character('b'));
        	queue2.addLast(new Character('$'));
        	queue2.addLast(new Character('E'));
        	queue2.addLast(new Character('b'));
		System.out.println("dup check = " +
                    identicalCheck(queue1, queue2));
		findAndReplace(queue1, key, new Character('*'));
		System.out.println("** After findAndReplace **");
		printQueue(queue1);
		//printQueue(queue2);
	}

	private static boolean identicalCheck(LinkedList queue1,
                                              LinkedList queue2)
                throws CloneNotSupportedException
	{
		boolean isIdentical = false;
		int trueCount = 0;
		Object[] Q1 = queue1.toArray(); //Creates arrays for each of the linked lists so that I can compare by index value. 
		Object[] Q2 = queue2.toArray();

		if (Q1.length == Q2.length) //If the queues are th same size, then it will go into these options
		{
			for (int i = 0; i <= Q1.length-1; i++) //Goes one by one ad determines if they are all the same and in the same order. 
			{
				if (((Comparable)Q1[i]).compareTo(Q2[i]) == 0) //Increaes a variable called trueCount if the things in the slots of the queues are the same.
				{
					trueCount ++;
				}
			}
			if (trueCount == Q1.length) //Compares the length of the number of True responses to see if all of the things matched up in the same order. 
				isIdentical = true;
		}
		return isIdentical; //If the program doesn't mark the queues as identical in the previous parts, then it will return true. 
	}


	private static void findAndReplace(LinkedList queue1, 
		Object key, Object newVal)
	{
		do
		{
			int index = queue1.indexOf(key);
			queue1.set(index, newVal);
		}while (queue1.indexOf(key) != -1); //While the key is found in the queue, keep replacing the key with the newVal.
	}



	private static void printQueue (LinkedList q)
		 throws CloneNotSupportedException
	{
		LinkedList temp = (LinkedList)(q.clone());
		//LinkedList temp = new LinkedList();
		if (temp.isEmpty() == true)
			System.out.println("The Queue you're trying to print is empty.");
		else
		{
			while (! temp.isEmpty())
			{
				System.out.print(temp.pop()+" ");
			}
			System.out.println();
	}


	}

}
