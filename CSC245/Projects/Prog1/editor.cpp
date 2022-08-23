#include <string>
#include <iostream>
#include <fstream>
#include <cstdlib>
#include "linelist.h"

using namespace std;

void options(char *argv[], LineList& myList, char& command);
void begin(int argc, char *argv[], LineList& myList);
void openFile(ifstream& infile, int argc, char *argv[]);
void readAndBuild (ifstream& infile, LineList& myList);
void writeFile(char *argv[], LineList& myList);
void enterComm(LineList& myList, char& command);
void insert (LineList& myList);

int main(int argc, char *argv[])
{
    LineList myList;    char command;
    begin(argc, argv, myList);
    options(argv, myList, command);

}//End Main()

void options(char *argv[], LineList& myList, char& command)
{
    do 
    {
        enterComm(myList, command);

        switch (command)
        {
            case 'L':
                if (myList.getLength() == 0)
                {
                    cout << "Error: This file is empty. Please insert a line first or exit your file." << endl;
                    break;
                }
                else
                    myList.printList(); break;
            case 'I':
                insert(myList); break;
            case 'D': 
                if (myList.getLength() == 0)
                {
                    cout << "Error: This file is empty. Please insert a line first or exit your file." << endl;
                    break;
                }
                else
                    myList.deleteLine(); break;
            case 'N': 
                myList.moveNextLine(); break;
            case 'P': 
                myList.movePrevLine(); break;
            
        }
    }while (command != 'E'); //End do-while

    writeFile(argv, myList);
}//End optons()

void begin(int argc, char *argv[], LineList& myList)
{
    ifstream infile;
    openFile(infile, argc, argv);
    readAndBuild(infile, myList);
    if (myList.getLength() != 0)
    {
        myList.printList();
    }
    myList.goToBottom();
}//End begin()

void openFile(ifstream& infile, int argc, char *argv[])
{
    if (argc == 1)
    {
        cout << "Error -- No Filename Entered!" << endl;
        exit(1);
    }
    string fileName = argv[argc-1];
    infile.open(fileName.c_str());
}//End openFile()

void readAndBuild(ifstream& infile, LineList& myList)
{
    string myText;
    // Use a while loop together with the getline() function to read the file line by line
    while (getline (infile, myText)) {
        // Output the text from the file
        myList.insertLine(myText);
    }

    // Close the file
    infile.close();
}//End readAndBuild()

void writeFile(char *argv[], LineList& myList)
{
    ofstream outfile;
    string fileName = argv[1];
    
    outfile.open(fileName.c_str());
    myList.goToTop();

    for (int i = 0; i < myList.getLength(); i++)
    {
        outfile << myList.getCurrLine() << endl;
        myList.moveNextLine();
    }

    outfile.close();
}//End openFile()

void enterComm(LineList& myList, char& command)
{
    cout << myList.getCurrLineNum() << "> ";
    cin >> command;
    cin.ignore(80, '\n');
}//End enterComm()

void insert (LineList& myList)
{
    string insertMessage;
    cout << myList.getCurrLineNum() + 1 << "> " ;
    getline(cin, insertMessage);
    myList.insertLine(insertMessage);
}//End insert()