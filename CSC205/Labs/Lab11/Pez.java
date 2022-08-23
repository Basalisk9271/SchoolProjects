import java.io.*;
@SuppressWarnings("unchecked")

public class Pez
{
    public static Stack pez = new Stack();

    public static void main (String[] args) throws CloneNotSupportedException
    {
        addPez();
        printStack(pez);
        removeGreen(pez);
        printStack(pez);
    }//End Main

    public static void addPez()
    {
        pez.push(new String("yellow"));
        pez.push(new String("red"));
        pez.push(new String("green"));
        pez.push(new String("green"));
        pez.push(new String("yellow"));
        pez.push(new String("yellow"));
        pez.push(new String("red"));
        pez.push(new String("green"));
    }//End addPez()

    public static void removeGreen(Stack s)
    {
        Stack temp = new Stack();
        //String tempStr = "";
        
        while (! s.isEmpty())
        {
            if (((Comparable)s.top()).compareTo("green") == 0)
                s.pop();
            else
            {
                
                temp.push(((String)s.top()));
                s.pop();
            }
        }
        while (! temp.isEmpty())
        {
            s.push(((String)temp.pop()));
        }
    }

    public static void printStack (Stack s) throws CloneNotSupportedException
  {
        Stack tempStack = (Stack) (s.clone());
        if (! tempStack.isEmpty())
                System.out.println("Pez:  ");

        while (! tempStack.isEmpty())
        {
               System.out.println(tempStack.top());
               tempStack.pop();
        }
  }
}