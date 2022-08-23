//Part of Lab 6 - Create an Employee class that extends Person.java
//Created by Gabe Imlay
//Created October 4, 2021
import java.util.*;
public class Employee extends Person
{
    private double salary; //Initializes salary
    private Date hired; //Initializes date

    public Employee (String lastName, String firstName, Date birthDate, double Salary, Date Hired)
    {
        super(lastName, firstName, birthDate);
        salary = Salary;
        hired = Hired;

    }//End Employee Constructor

    public double getSalary() 
    {
        return salary;
    }//End getSalary()

    public Date getHireDate() 
    {
        return hired;
    }//End getHireDate

    public void setSalary(double salary)
    {
        this.salary = salary;
    }//End setSalary()

    public void setHireDate(Date hired)
    {
        this.hired = hired;
    }//End setHireDate()


    public String toString()
    {
        return "Name: "+getLastName()+", "+getFirstName()+"\nSalary: $"+getSalary()+"\nBirth: "+getBirthDate()+"\nHired: "+getHireDate();
    }//End toString
}//End Employee