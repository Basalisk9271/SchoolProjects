import java.io.*;

public class HourlyEmployee extends Employee implements Serializable
{
    public double wage;

    public HourlyEmployee(String Name, double Wage)
    {
        super(Name, Wage);
        this.wage = Wage;
    }

    public double computePay(double hours)
    {
        double hrs = hours;
        double pay;
        if (hrs > 40)
        {
            pay = (wage * 40)+((wage*1.5)*(hrs-40));
        }
        else
        {
            pay = wage * hrs;
        }
        return pay;
    }

    public void setWage(double newWage)
    {
        wage = newWage;
    }

    public double getWage()
    {
        return wage;
    }

    public void raiseWages(double percentage)
    {
        double increase = 1+(percentage/100);
        setWage(wage * increase);
    }

    public String toString()
    {
        return pad(getName() + "\t\t$" + toDollars(getWage()) + "/hour", 40);
    }
}