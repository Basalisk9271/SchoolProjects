import java.util.*;

public class mySums
{
    public static void main(String[] args)
    {
        System.out.println(iterativeSums(4));
        System.out.println(recurSums(4));
    }
    public static double iterativeSums(int n)
    {
        double sum = 0;
        for (int i = 1; i<=n; i++)
        {
            sum += (Math.pow(2,i)+1);
        }
        return sum;
    }
    public static double recurSums(int n)
    {
        double sum = 0;
        if (n == 1)
        {
            return 3;
        }
    
    }
}
