
import java.util.*;

public class Sets
{
	private static final int BOUND = 8;
	public static void main(String[] args)
	{
		BitSet set1 = new BitSet(BOUND);
		BitSet set2 = new BitSet(BOUND);
		
		for (int i = 1;  i < BOUND;  i *= 2)
			set1.set(i);

		for (int i = BOUND-1;  i > 0;  i /= 2)
			set2.set(i);
	
		System.out.print("set1 = ");
		print(set1);
		System.out.print("set2 = ");
		print(set2);

		System.out.print("\ninverse of set1 = ");
		print(inverse(set1));
		System.out.print("inverse of set2 = ");
		print(inverse(set2));

	}
	public static void print(BitSet set)
	{
		for (int i = 0; i<BOUND; i++)
		{
		if (set.get(i)==true)
			System.out.print("1 ");
		else 
			System.out.print("0 ");
		}
		System.out.println();
	}
	public static BitSet inverse(BitSet set)
	{
		set.flip(0,8);
		return set;
	}


}
