import java.io.*;

public class SalariedEmployee extends Employee implements Serializable
{
    public double salary;

    public SalariedEmployee(String Name, double Salary)
    {
        super(Name, Salary/(40*52));
        this.salary = Salary;
    }

    public double computePay(double hours)
    {
        return salary/52;
    }
    public double getSalary()
    {
        return salary;
    }
    public void setSalary(double newSalary)
    {
        salary = newSalary;
    }

    public void raiseWages(double percentage)
    {
        double increase = 1+(percentage/100);
        setSalary(salary*increase);
    }

    public String toString()
    {
        return pad(getName() + "\t\t$" + toDollars(getSalary()) + "/year", 40);
    }
}