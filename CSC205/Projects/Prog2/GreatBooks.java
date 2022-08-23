//Project 2 - Great Books Library System: Create a library system to receive and sort great Books entries
//Created by Gabe Imlay
//Created October 10, 2021

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class GreatBooks 
{
    public static int choice;
    public static String[] booksArr;
    public static Scanner ret = new Scanner(System.in);
    public static ArrayList<LibraryBook> booksArrLst = new ArrayList<LibraryBook>(50);

    public static void main(String[] args) throws FileNotFoundException
    {
        
        inputRecords(openFile());
        clearScreen();
        Choices();
    }//End main()

    public static int menu()
    //Display a menu of choices that will send user to different options based on which choice they make; menu repeats
    {
        int menuChoice = 0;
        do
        {
        Scanner menuIn = new Scanner(System.in);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("\t   THE GREAT BOOKS SEARCH PROGRAM");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("1) Display All Book Records");
        System.out.println("2) Search For a Book By Title");
        System.out.println("3) Exit Search Program");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.print("Please Enter Your Choice >");
        if (menuIn.hasNextLine()) {
            String strChoice = menuIn.nextLine();
            
            if (strChoice.compareTo("1") == 0)
            {
                menuChoice = 1;
            }
            else if (strChoice.compareTo("2") == 0)
            {
                menuChoice = 2;
            }
            else if (strChoice.compareTo("3") == 0)
            {
                menuChoice = 3;
            }
            else
            {
            System.out.print("\nYou have made an error. Please try again.\n\nPlease Hit Return to Continue...");
            ret.nextLine();
            clearScreen();
            }

        }//End if 
        } while(menuChoice < 1 || menuChoice > 3); //Do-while to control what the choice is
        return menuChoice;
        
    }//End menu()

    public static void Choices()
    {
        int caseCtrl = 0;
        fillLibArr(booksArr);
        do{
        clearScreen();
        switch (menu())
        {
            case 1: displayRecords(booksArr);
                    break;
            //Case 1 Displays all of the book records in alphabetical order
            case 2: search();
                    break;
            //Case 2 Lets the user search for a book by title
            case 3: System.out.println("\nThanks for Using the Great Books Search Program! Have a Nice Day!\n");
                    caseCtrl = 1;
                    System.exit(0);
                    break;
             //Case 3 exits the program

        }//End switch
        }while (caseCtrl != 1);
    }//End choices()

    public static String openFile()
    {
        int loopCtrl = 0;
        String fileName = "";
        Scanner fileSelect = new Scanner(System.in);
        System.out.println("\t\t\tTHE BOOK SEARCH PROGRAM");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("\n\tWhat file is your book stored in?\n");
        do{
        System.out.println("\tHere are the files in the current directory: \n");
        //Get all files from directory
        File curDir = new File(".");
        String[] fileNames = curDir.list();
        ArrayList<String> data = new ArrayList<String>();

        //Find files which may have data. (aka, are in the .dat format)
        for(String s:fileNames)
                if(s.endsWith(".dat"))
                        data.add(s);
        
        System.out.print("| ");
        for (int i=0; i<data.size();i++)
            System.out.print(data.get(i)+" | ");
        System.out.println();
        System.out.print("\n\tFilename: ");
        fileName = fileSelect.next();
        //System.out.println("Name Entered: "+fileName);
        if (fileName.endsWith(".dat") && data.contains(fileName))
        {    
            loopCtrl = 1;
            //System.out.println("File Chosen...");
            return fileName;
        }
        else 
            System.out.println("\n** Can't open input file.  Try again. **\n");
        }while (loopCtrl != 1);
        
        return fileName;
    }//End openFile()

    public static void inputRecords(String fileName) throws FileNotFoundException
    {
        Scanner inFile = new Scanner(new File(fileName));
        ArrayList<String> temp = new ArrayList<String>();
        while (inFile.hasNextLine())
        {
            temp.add(inFile.nextLine());
        }
        booksArr = temp.toArray(new String[0]);
        selectionSort(booksArr); 
        System.out.println("\n\tA total of "+booksArr.length+" books have been input and sorted by title.\n");
        System.out.println("\tPlease Hit Return to Continue...\n");
        ret.nextLine();
    }//End inputRecords()

    public static void displayRecords(String[] books)
    {
        
        clearScreen();
        for (int j = 0; j<books.length; j++)
        {
            printRecord(booksArrLst, j);
            //ret.nextLine();
            if (ret.nextLine().compareTo("M") == 0)
                break;
            clearScreen();
        }
        
    }//End displayRecords()

    public static void fillLibArr(String[] books)
    {
        for (int i = 0; i<books.length; i++)
        {
            String str = books[i];
            String[] arrOfStr = str.split(";");

            String title = arrOfStr[0];                    
            String name = arrOfStr[1];                    
            int copyright = Integer.parseInt(arrOfStr[2]);                    
            double price = Double.parseDouble(arrOfStr[3]);                    
            String genre = arrOfStr[4];

            switch (genre)
            {
                case "f": genre = "Fiction";
                          break;
                
                case "n": genre = "Non-Fiction";
                          break;

                case "d": genre = "Drama";
                          break;

                case "p": genre = "Poetry";
                          break;
            }

            booksArrLst.add(new LibraryBook(title,name,copyright,price,genre));                    
        }
    }//End fillLibArr()

    public static void printRecord(ArrayList<LibraryBook> books, int location) {   
        System.out.println("Record #" + (location + 1) + " :\n");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");   
        System.out.println("Title:\t\t\t" + books.get(location).getTitle());   
        System.out.println("Author's Name:\t\t" + books.get(location).getAuthor());   
        System.out.println("Copyright:\t\t" + books.get(location).getCopyright());   
        System.out.println("Price:\t\t\t$" + books.get(location).getPrice());   
        System.out.println("Genre:\t\t\t" + books.get(location).getGenre() + "\n");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.print("\nPlease Hit Return to Continue or M for Menu...");        
    }//End printRecord()

    public static void search()
    {
        String[] titles = new String[booksArrLst.size()];
        
        for (int i = 0; i<titles.length; i++)
        {
            titles[i] = booksArrLst.get(i).getTitle();
        }
        System.out.print("\nSearch Title > ");
        String searchTerm = ret.nextLine();
        int bookIndex = binarySearch(titles, searchTerm);
        
        if (binarySearch(titles, searchTerm) >= 0)
        {
            String str = booksArr[bookIndex];
            String[] arrOfStr = str.split(";");

            String title = arrOfStr[0];                    
            String name = arrOfStr[1];                    
            int copyright = Integer.parseInt(arrOfStr[2]);                    
            double price = Double.parseDouble(arrOfStr[3]);                    
            String genre = arrOfStr[4];
            switch (genre)
            {
                case "f": genre = "Fiction";
                          break;
                
                case "n": genre = "Non-Fiction";
                          break;

                case "d": genre = "Drama";
                          break;

                case "p": genre = "Poetry";
                          break;
            }
            LibraryBook searchedBook = new LibraryBook(title,name,copyright,price,genre);

            clearScreen();
            System.out.println("Record #" + (binarySearch(titles, searchTerm) + 1) + " :\n");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");   
            System.out.println("Title:\t\t\t" + searchedBook.getTitle());   
            System.out.println("Author's Name:\t\t" + searchedBook.getAuthor());   
            System.out.println("Copyright:\t\t" + searchedBook.getCopyright());   
            System.out.println("Price:\t\t\t$" + searchedBook.getPrice());   
            System.out.println("Genre:\t\t\t" + searchedBook.getGenre() + "\n");
            System.out.print("\nPlease Hit Return to Continue ...");
            ret.nextLine();
        }//End if
        else
        {
            System.out.print("\nSorry, the book was not found.\n\nPlease Hit Return to Continue...");
            ret.nextLine();
        }//End else
    }//End search()

    private static void clearScreen()
    {
        System.out.print("\033[H\033[2J");
    }//End clearScreen()

    private static void selectionSort (String[] list)  {        
        int minIndex, index, j;        
        String temp;        
        for (index = 0; index < list.length-1; index++)        
        {                
            minIndex = index;                
            for (j = minIndex+1; j < list.length;  j++)                        
            if (list[j].compareTo(list[minIndex]) < 0 )                                
                minIndex = j;                
            if (minIndex != index)                
            {                    
                temp = list[index];                    
                list[index] = list[minIndex];                    
                list[minIndex] = temp;                
            }        
        }  
    }//End selectionSort()
    public static int binarySearch(String[] a, String x) {
        int low = 0;
        int high = a.length - 1;
        int mid;
    
        while (low <= high) {
            mid = (low + high) / 2;
    
            if (a[mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (a[mid].compareTo(x) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
    
        return -1;
    }//End binarySearch()
    

}//End GreatBooks class
