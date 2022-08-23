//Tester class for the employee class
//Created by Gabe Imlay
//Created October 4, 2021
import java.util.*;

public class TestEmployee
{
    public static void main (String[] args)
    {
        Date employeeBirth = new Date(1980, 03, 8);
        Date employeeHire = new Date(2021, 02, 5);
        Person mBrown = new Employee("Brown", "Morris", employeeBirth , 40000.0, employeeHire);
        System.out.println(mBrown);
    }
}