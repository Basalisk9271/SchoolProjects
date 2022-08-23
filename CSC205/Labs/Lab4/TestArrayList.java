import java.util.*;
public class TestArrayList
{
    public static void main(String[] args)
    {
	ArrayList<String> myArrayList = new ArrayList<String>(10);
	myArrayList.add("Python");
    myArrayList.add("Java");
    myArrayList.add("Java");
    myArrayList.add("Java");
    myArrayList.add("Java");
    myArrayList.add("Java");
    myArrayList.add("C++");
    myArrayList.add("C++");
    myArrayList.add("C++");
    myArrayList.add("C++");
    //printArrayList(myArrayList);
    delete(myArrayList, "Java"); //Deletes all instances of "Java" from ArrayList
    System.out.println(count(myArrayList, "C++")); //Counts the number of occurances of "C++"




    }

    private static void printArrayList(ArrayList<String> myArrayList)
    {
	// Pre  : myArrayList has been initialized
	// Post : The elements of Vector v are printed to the screen on separate lines
        for (int i = 0; i < myArrayList.size(); i++)
            System.out.println(myArrayList.get(i)+" ");



    }

    private static void delete(ArrayList<String> myArrayList, Object key)
    {
	// Pre  : myArrayList has been initialized
	// Post : All copies of key are removed from myArrayList

    int index = myArrayList.indexOf(key);

    while (index > 0)
    {
        myArrayList.remove(index);
        index = myArrayList.indexOf(key);
    }//End While
    printArrayList(myArrayList);   
    }//End delete()

    private static int count(ArrayList<String> myArrayList, Object key)
    {
	// Pre  : myArrayList has been initialized
	// Post : number of occurrences of key is computed and returned
        int num = 0;
        for (int k = 0; k < myArrayList.size(); k++)
        {
            if (myArrayList.get(k).equals(key))
                num++;
        }//End for 
        return num;
    }//End count()
}
