//Part of Lab 6 - Create a Checking Account class that extends Account.java
//Created by Gabe Imlay
//Created October 4, 2021

public class CheckingAccount extends Account
{
    public int numChecks; //initializes numChecks

    public CheckingAccount(double initialBalance)
    {
        super(initialBalance);
        numChecks = 0;
    }//end CheckingAccount constructor

    public int getChecksWritten()
    {
        return numChecks;
    }//end getChecksWritten()

    public void writeCheck (double checkAmt)
    {
        withdraw(checkAmt);
        numChecks++;
        
    }//end writeCheck()
}//End Checking Account