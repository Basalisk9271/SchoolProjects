import java.io.*;

abstract class Employee implements Serializable
{
    public String name;
    public double wage;

   /* public Employee()
    {
        name = "";
        wage = 0;
    }*/

    public Employee(String Name, double Wage)
    {
        name = Name;
        wage = Wage;
    }
    public abstract double computePay(double hours);

    public String getName()
    {
        return name;
    }

    public double getWage()
    {
        return wage;
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public void setWage(double newWage)
    {
        wage = newWage;
    }

    public void raiseWages(double percentage)
    {
        double increase = 1+(percentage/100);
        wage *= increase;
    }

    public static String pad(String str, int n) {
        if (str.length() > n)
          return str.substring(0, n);
        while (str.length() < n)
          str += " ";
        return str;
      }
    
    public static String toDollars(double amount) {
    long roundedAmount = Math.round(amount * 100);
    long dollars = roundedAmount / 100;
    long cents = roundedAmount % 100;
    
    if (cents <= 9)
        return dollars + ".0" + cents;
    else
        return dollars + "." + cents;
    }
}