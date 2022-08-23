//Personnel Class to run the program for Project 3
//Created by Gabe Imlay
//November 10, 2021
//test
import java.util.*;
import java.io.*;
@SuppressWarnings("unchecked")

public class Personnel implements Serializable
{
    public static ArrayList<Employee> empArrList = new ArrayList<Employee>();
    public static Scanner ret = new Scanner(System.in);

    public static void main(String[] args)
    {
        Choices();
    }
	public static int menu()
    //Display a menu of choices that will send user to different options based on which choice they make; menu repeats
    {
        int menuChoice = 0;
        do
        {
        clearScreen();
        Scanner menuIn = new Scanner(System.in);
        Line(34, '-');
        System.out.println("|Commands: n - New Employee      |");
        System.out.println("|          c - Compute Paychecks |");
        System.out.println("|          r - Raise Wages       |");
		System.out.println("|          p - Print Records     |");
		System.out.println("|          d - Download Data     |");
		System.out.println("|          u - Upload Data       |");
		System.out.println("|          q - Quit              |");
		Line(34, '-');
        System.out.print("\nEnter Command: ");
        if (menuIn.hasNextLine()) {
            String strChoice = (menuIn.nextLine()).toLowerCase().replaceAll(" ", "");
            
            if (strChoice.compareTo("n") == 0)
            {
                menuChoice = 1;
            }
            else if (strChoice.compareTo("c") == 0)
            {
                menuChoice = 2;
            }
            else if (strChoice.compareTo("r") == 0)
            {
                menuChoice = 3;
            }
			else if (strChoice.compareTo("p") == 0)
            {
                menuChoice = 4;
            }
			else if (strChoice.compareTo("d") == 0)
            {
                menuChoice = 5;
            }
			else if (strChoice.compareTo("u") == 0)
            {
                menuChoice = 6;
            }
			else if (strChoice.compareTo("q") == 0)
            {
                menuChoice = 7;
            }
            else
            {
                System.out.print("\nCommand was not recognized; please try again.\n");
                System.out.println("\nHit return to continue...");
                ret.nextLine();
            }

        }//End if 
        } while(menuChoice < 1 || menuChoice > 7); //Do-while to control what the choice is
        return menuChoice;
        
    }//End menu()

	public static void Choices()
    {
        int caseCtrl = 0;
        do{
        switch (menu())
        {
            case 1: addEmployee();
                    break;
            //Case 1 Displays all of the book records in alphabetical order
            case 2:computeCheck();
                    break;
            //Case 2 Lets the user search for a book by title
			case 3: giveRaise();
                    break;
			case 4: printRecords();
                    break;
			case 5: download();
                    break;
			case 6: upload();
                    break;
            case 7: System.out.println("\nThis concludes your Personnel Terminal session. Goodbye\n");
                    caseCtrl = 1;
                    System.exit(0);
                    break;
             //Case 7 exits the program

        }//End switch
        }while (caseCtrl != 1);
    }//End choices()

    public static void addEmployee()
    {
        Scanner newIn = new Scanner(System.in);
        String name, choice;
        double pay;
        int loopControl = 0;
        Employee newEmployee;
        System.out.print("Enter name of new employee: ");
        name = newIn.nextLine();
        do{
            System.out.print("Hourly (h) or Salaried (s): ");
            choice = newIn.nextLine();
            if ((choice.toLowerCase().replaceAll(" ","")).compareTo("h") == 0)
            {
                int hourCtrl = 0;
                do{
                System.out.print("Enter hourly wage: ");
                pay = newIn.nextDouble();
                if (pay > 0)
                {
                    
                    hourCtrl = 1;
                }//end if
                else
                {
                    System.out.println("Please enter a valid Hourly Wage.");
                }//end else
                }while (hourCtrl != 1); //end do-while to proof the hourly wage
                newEmployee = new HourlyEmployee(name, pay);
                empArrList.add(newEmployee);
                loopControl = 1;
            }//end if
            else if ((choice.toLowerCase().replaceAll(" ","")).compareTo("s") == 0)
            {
                int salaryCtrl = 0;
                do{
                    System.out.print("Enter annual salary: ");
                    pay = newIn.nextDouble();
                    if (pay > 0)
                    {
                        salaryCtrl = 1;
                    }//end if
                    else
                    {
                        System.out.println("Please enter a valid Annual Salary.");
                    }//end else
                }while(salaryCtrl != 1); //end do-while to proof the salary
                newEmployee = new SalariedEmployee(name, pay);
                empArrList.add(newEmployee);
                loopControl = 1;
            }//end else if
            else
            {
                System.out.println("Input was not h or s; please try again.");
            }//end else
        }while(loopControl != 1); //End do-while to make sure the user inputs the proper choice h or s
        clearScreen();
    }//End addEmployee()

    public static void computeCheck()
    {
        Scanner computeIn = new Scanner(System.in);
        double hours;
        for (int i = 0; i < empArrList.size(); i++)
        {
            System.out.print("\nEnter number of hours worked by "+(empArrList.get(i)).getName()+": ");
            hours = computeIn.nextDouble();
            System.out.print("Pay: $"+Employee.toDollars((empArrList.get(i)).computePay(hours))+"\n");
        }
        System.out.println();
        System.out.println("Hit return to continue...");
        ret.nextLine();
        clearScreen();
    }//End computeCheck()

    public static void giveRaise()
    {
        Scanner raiseIn = new Scanner(System.in);
        double raise;
        int percentCtrl = 0;
        
        do {
            System.out.print("\nEnter percentage increase: ");
            raise = raiseIn.nextDouble();
            if (raise > 0)
            {
                percentCtrl = 1;
            }
            else
            {
                System.out.println("\nInvalid percentage. Please enter a valid percentage greater then zero.");
            }
        }while(percentCtrl != 1);
        
        System.out.println("\nNew Wages");
        Line(9, '-');
        for (int i = 0; i < empArrList.size(); i++)
        {
            (empArrList.get(i)).raiseWages(raise);
            System.out.println(empArrList.get(i));
        }
        System.out.println();
        System.out.println("Hit return to continue...");
        ret.nextLine();
        clearScreen();
    }//end giveRaise()

    public static void printRecords()
    {
        for (int i = 0; i < empArrList.size(); i++)
            System.out.println(empArrList.get(i));
        System.out.println("\nHit return to continue...");
        ret.nextLine();
        clearScreen();
    }//end printRecords()

    public static void upload()
    {
        String fileName = "employee.dat";
        ArrayList<Employee> temp = null;
        try {
          FileInputStream fileIn = new FileInputStream(fileName);
          ObjectInputStream in = new ObjectInputStream(fileIn);
          temp = (ArrayList<Employee>) in.readObject();
          for (Employee person: temp) empArrList.add(person);
          in.close();
        }
        catch (IOException e) {
          System.out.println(e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
          System.out.println(e.getMessage());
        }
        catch (ClassCastException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("\nHit return to continue...");
        ret.nextLine();
        clearScreen();
    }//end upload()

    public static void download()
    {
        String fileName = "employee.dat";
        //int[] a = {1, 2, 3};
        try {
          FileOutputStream fileOut = new FileOutputStream(fileName);
          ObjectOutputStream out = new ObjectOutputStream(fileOut);
          out.writeObject(empArrList);
          out.close();
        }
        catch (IOException e) {
          System.out.println(e.getMessage());
        }
        System.out.println("\nHit return to continue...");
        ret.nextLine();
        clearScreen();
    }//end download()

    public static void clearScreen()
	{
		System.out.println("\u001b[H\u001b[2J");
	}//End clearScreen()

	public static void Line(int n, char ch)
	{
		for (int i=1; i<=n; i++)
		  System.out.print(ch);
		System.out.println();
	}//End Line()

    
}