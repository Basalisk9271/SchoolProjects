//This is a Project for playing a GAME of BINGO based on an input file of BINGO Values
//Gabe Imlay
//September 22, 2021

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class BINGO{

public static int random, numPicks, sum;
public static int [][] card = new int[5][5];
public static boolean win = false;
public static ArrayList<Integer> randNum = new ArrayList<>();

public static final int HORIZONTAL = 1;
public static final int VERTICAL = 2;
public static final int DIAGONAL = 3;

public static void main (String[] args)
{
	playGame(); //Calls method to run entire game
}//End Main()
//--------------------------------------------------------------
public static void randomNums(int[][] card) //Method to choose number at random
{
    do
    {
        random = (int) Math.round((Math.random() * 74 + 1));
    }while(randNum.contains(random));

    randNum.add(random);
    numPicks++;

}//End randomNums()
//--------------------------------------------------------------
public static void printRand() //Prints the ArrayList of random numbers
{
System.out.print("BINGO NUMBERS PICKED AT RANDOM FROM BIN : ");
for (int ALI = 0;ALI < randNum.size(); ALI++)
    if (ALI % 10 == 0)
    {
        System.out.print("\n");
        System.out.print(randNum.get(ALI)+"\t");
    }
    else 
        System.out.print(randNum.get(ALI)+"\t");

    System.out.println();
}
//--------------------------------------------------------------
public static void fillCard(int[][] card) //Reads the input file into the array card[][]
    throws FileNotFoundException
{
    int [][] Card = card ;
    
    File inputFile = new File("bingo.in");
    Scanner inFile = new Scanner(inputFile);
    while(inFile.hasNextInt())
    {
        
        for (int j = 0; j<Card.length;j++)
        {
        for (int k = 0; k< Card[j].length;k++)
            {
                Card [j] [k] = Integer.parseInt(inFile.next()); //change value from String type to int
            }//End Column Loop
        }//End Row Loop
    }
}//End fillCard()
//--------------------------------------------------------------
public static void printCard(int [][] card) //Prints the card, replacing every zero with an "X"
{
System.out.println();
System.out.println("B\tI\tN\tG\tO");
System.out.println("-\t-\t-\t-\t-");
for (int j = 0; j<card.length;j++)
        {
        for (int k = 0; k< card[j].length;k++)
            {
                if(card[j][k] == 0)
                System.out.print("X\t");
                else
                System.out.print(card[j][k]+"\t");
            }//End Column Loop
            System.out.println();
        }//End Row Loop

}//End printCard()
//--------------------------------------------------------------
public static int checkWin(int [][] card) //Checks the card for a win horizontally, vertically, or diagonally
{
win = false;

//horizontal rows
sum = 0;
for (int j = 0; j<card.length;j++) 
        {
        sum = 0;
        for (int k = 0; k< card[j].length;k++)
            {
                sum+=card[j][k];
            }//End Column Loop
            if (sum == 0)
            {
                return HORIZONTAL;
            }//End if
        }//End Row Loop

// Vertical Columns 
sum = 0;
for (int j = 0; j<card[0].length;j++) 
        {
        sum = 0;
        for (int k = 0; k< card.length;k++)
            {
                sum+=card[k][j];
            }//End Column Loop
            if (sum == 0)
            {
                return VERTICAL;
            }//End if
        }//End Row Loop

// Diagonally from left to right 
sum = 0;

        for (int k = 0; k< card.length;k++)
            {
                sum+=card[k][k];
            }//End Column Loop
            if (sum == 0)
            {
                return DIAGONAL;
            }//End if

// Diagonally from right to left 

sum = 0;
for (int j = 0; j<card.length;j++) 
{
    sum+=card[j][card.length-j-1];
    
    
}//End Loop
if (sum == 0)
{
    return DIAGONAL;
}//End if
        sum=0;

return 0;

}//End checkWin()
//--------------------------------------------------------------
public static void checkCard() //Checks the card for matches for the random class variable; if found, they are changed to zeros
{
    for (int j = 0; j<card.length;j++)
    {
        for (int k = 0; k< card[j].length;k++)
        {
            if(card[j][k] == random)
            card[j][k] = 0;
        }//End Column Loop
    }//End Row Loop
}//End checkCard()
//--------------------------------------------------------------
public static void results(int choice) //Display results based off of an instance of the checkWin() method
{
    if(choice == 1)
    {
    switch (checkWin(card)){
        
        case (1): 
            System.out.println("\n");
            win = true;
            break;
        case(2):
            System.out.println("\n");
            win = true;
            break;
       case(3):
            System.out.println("\n");
            win = true;
            break;
        default:
            win = false;
            
    }//End Switch 
}//End If
    else 
    {
        switch (checkWin(card)){
        
            case (1): 
                System.out.println("\nYOU WIN WITH A HORIZONTAL BINGO AFTER "+numPicks+" PICKS!");
                //win = true;
                break;
            case(2):
                System.out.println("\nYOU WIN WITH A VERTICAL BINGO AFTER "+numPicks+" PICKS!");
                //win = true;
                break;
           case(3):
                System.out.println("\nYOU WIN WITH A DIAGONAL BINGO AFTER "+numPicks+" PICKS!");
                //win = true;
                break;
            default:
                win = false;
                
        }//End Switch 
    }

}//End results()
//--------------------------------------------------------------
public static void playGame() //Method to call all of the other methods to run the entire bingo game
{
    try {
        fillCard(card);
    } catch (FileNotFoundException e) {
        System.out.println("Invalid File");
    }
    System.out.println("\nYour Bingo Card:");
    printCard(card);
    do
    {
        randomNums(card);
        results(1);
        checkCard();
        
        
    }while(win != true);
    printRand();
    results(2);
    checkCard();
    printCard(card);
    System.out.println();
}//End playGame()
}//End BINGO class