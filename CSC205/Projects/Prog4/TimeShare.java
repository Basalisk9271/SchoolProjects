 //Project 4 - The Job Queue
 //Created by Gabe Imlay
 //Due December 13, 2021

 import java.util.*;
 import java.io.*;
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.text.DecimalFormat;
 @SuppressWarnings("unchecked")

 public class TimeShare {
    
  public static String[] jobArr;
  public static ArrayList<Job> jobsArrLst = new ArrayList<Job>();
  public static double clock, idle, usage;
  public static ArrayList<Job> jobsArrLstProc = new ArrayList<Job>();
  public static Queue jobQ = new Queue();
  public static Queue outputQ = new Queue();
  public static Queue inputQ = new Queue();
  

    public static void main(String[] args) 
    {
      try {
        run(args);
      } catch (FileNotFoundException e) {
        System.out.println("File not found. Please try again with valid file.\n");
      }
         
    }//End Main()

    public static void run(String[] args) throws FileNotFoundException
    {//Runs the entire program
      clearScreen();
      
      if(fileAvailable(args) == true)
      {
           inputJobs(args);
           System.out.println();
           menu();
           processJobs(inputQ, jobQ, outputQ, clock, idle, usage);
           //calcStat(outputQ);
           
      }//End if
      else 
      {
         System.out.println("\nNo file was selected. Please try again.\n");
      }//End else
    }//End run()

    public static void menu() //Displays the menu of the program
    { 
      System.out.println("Job Control Analysis: Summary Report \n");       
      System.out.println("Job ID\t\tArrival\t\tStart\t\tRun\t\tWait\t\tTurnaround\n                time\t\ttime\t\ttime\t\ttime\t\ttime");
      System.out.println("------\t\t-------\t\t-----\t\t----\t\t----\t\t----------");              
    }//End menu()

    public static boolean fileAvailable(String[] args) //Checks to see if the file is available in the directory
    {
      if (0 < args.length) {
         return true;
      }
      else{
         return false;
      }
    }//End fileAvailable()

    public static void processJobs(Queue inputQ, Queue jobQ, Queue outputQ, double clock, double idle, double usage) 
    {
        clock = 1;
        idle = 0;
        usage = 0;

        for (int i = 0; i < jobsArrLst.size(); i++)
        {
          inputQ.enqueue(jobsArrLst.get(i));
          //System.out.println(jobsArrLst.get(i));
        }

        while(!inputQ.isEmpty() || !jobQ.isEmpty()) //while inputQ and jobQ are not empty, continue the program
        {
            if(inputQ.isEmpty() == false) //store the first job from the inputQ into the jobQ at the right time
            {
              Job first = (Job) inputQ.front();
              if (first.arrivalTime == clock)
              {
                jobQ.enqueue(first);
                inputQ.dequeue();
              }//End nested if
            }//End if

            if (jobQ.isEmpty() == false)
            {
                Job finished = (Job) jobQ.front();
                if (finished.startTime != -1 && finished.runTime == clock - finished.startTime) 
                //Check the first job in the jobQ to see if any jobs need to be removed at current clock time
                {
                  finished.turnTime = finished.waitTime + finished.runTime;
                  outputQ.enqueue(finished);
                  jobQ.dequeue();
                }//End nested if 

                if (!jobQ.isEmpty())
                {
                  Job start = (Job) jobQ.front(); //Starts unstarted Jobs during it's right time
                if(start.arrivalTime <= clock && start.startTime == -1)
                {
                  start.startTime = (int) clock;
                  start.waitTime = start.startTime - start.arrivalTime;
                }//End second nested if
                }
            }//End if

            if (jobQ.isEmpty() == true && inputQ.isEmpty() != true)
            {
              idle++;
            }//End if
            else
            {
              usage++;
            }

            clock++;
        }//End while loop
        printJobs(outputQ);
        calcStat(outputQ, idle);
    }//End processJobs()

    public static void calcStat(Queue outputQ, double idle)
    {
        double avgWait, waitTotal = 0, CPUusage = 0, CPUidle = idle, CPUpercent;
        int count = 0;
        Queue temp = new Queue();        
        DecimalFormat f = new DecimalFormat("##.00");

        while (!outputQ.isEmpty())
        {
          
            Job curr = (Job) outputQ.front();
            //System.out.println("Check 2");
            //System.out.println(curr);
            count++;
            waitTotal += curr.waitTime;
            CPUusage += curr.runTime;
            temp.enqueue(outputQ.dequeue());
        }//End while that calcs total waitTime
        System.out.println();
        avgWait = waitTotal / count;    //Averages the total waitTime 
        CPUpercent = (CPUusage/(CPUusage+CPUidle))*100;

        System.out.println("                   Average Wait Time => "+f.format(avgWait));
        System.out.println("                           CPU Usage => "+CPUusage);
        System.out.println("                            CPU Idle => "+idle);
        System.out.println("                       CPU Usage (%) => "+f.format(CPUpercent)+"%");
        System.out.println();
      
    }//End calcStat()

    public static void inputJobs(String[] args) throws FileNotFoundException
    {
      String fileName = args[0];
      File input = new File(fileName);
      Scanner inFile = new Scanner(input);
      ArrayList<String> temp = new ArrayList<String>();
      
      while (inFile.hasNextLine())
      {
          temp.add(inFile.nextLine());
      }//End while loop adding the jobs to an ArrayList of strings
      jobArr = temp.toArray(new String[0]); //Creates an array of Strings from the ArrayList of Strings previously
      for (int i = 0; i<jobArr.length; i++)
      {
          String str = jobArr[i];
          String[] arrOfStr = str.split("\t");
          String jobName = arrOfStr[0];                    
          int arrival = Integer.parseInt(arrOfStr[1]);
          int run = Integer.parseInt(arrOfStr[2]);                    
          jobsArrLst.add(new Job(jobName,arrival,run)); //Adds jobs to the proper ArrayList                   
      }//End for loop adding the jobs to an ArrayList
    }//End inputRecords()

    public static void printJobs(Queue outputQ) 
    {
      //Queue temp = outputQ;
      for (int i = 0; i < jobsArrLst.size(); i++)  //Print the jobs in the output queue
      {
        jobsArrLstProc.add((Job)outputQ.dequeue());
        System.out.println(jobsArrLstProc.get(i));
        outputQ.enqueue(jobsArrLstProc.get(i));
      }//End While
    }//End printJobs()

    public static void clearScreen()
    {
      System.out.println("\u001b[H\u001b[2J");
    }//End clearScreen()
 }