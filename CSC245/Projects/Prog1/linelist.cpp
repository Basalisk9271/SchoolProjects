
#include <iostream>
#include "linelist.h"

LineList::LineList()
{
	LineNode *line = new LineNode;
	LineNode *line2 = new LineNode;

	line -> info = topMessage;
	currLine = line;
	currLineNum = 1;
	length = 0;
	line2 -> info = bottomMessage;
	currLine -> back = NULL;
	currLine -> next = line2;
	line2 -> back = line;
	line2 -> next = NULL;
}//End constructor

void LineList::goToTop() 
{
	// Post : Advances currLine to line 1
	if (this -> getCurrLineNum() != 1)
	{
		while (currLine-> back -> info != topMessage)
		{
			currLine = currLine -> back;
			currLineNum--;
		}//End while
	}//End if 
}//End goToTop()

void LineList::goToBottom() 
{
	// Post : Advances currLine to last line
	if (this -> getLength() != this -> getCurrLineNum())
	{
		while (this -> getCurrLine() != topMessage)
		{
			currLine = currLine -> next;
			currLineNum++;
		}//End while
	}//End if
}//End goToBottom()

void LineList::insertLine(string newLine)
{
	// post : newLine has been inserted after the current line

	LineNode *temp = new LineNode;
	temp -> info = newLine;
	temp -> back = currLine;
	temp -> next = currLine -> next;
	currLine -> next = temp;
	currLine = currLine -> next;
	length++;
	

	if (currLine -> back -> info != topMessage)
	{
		currLineNum++;
	}//End if
	

}//End insertLine()

void LineList::deleteLine()
{
	// post : deletes the current line leaving currentLine
	//	  pointing to line following
	LineNode *temp = new LineNode;

	if (currLine -> back -> info == topMessage && this -> getLength() != 0)
	//Case to account for when currLine is at the first line and the linelist is not empty
	{
		temp = currLine -> next;
		temp -> info = currLine -> next -> info;
		delete currLine;
		currLine = new LineNode;
		currLine = temp;
		currLine -> next = temp -> next;
		currLine -> info = temp -> info;
		currLine -> back -> info = topMessage;
		if (this -> getCurrLineNum() > 1)
		{
			currLineNum--;
		}
		length--;
		
	}//End if
	
	else if (currLine -> next -> info == bottomMessage && this -> getLength() != 0)
	//Case to account for when currLine is the last line and the LineList is not empty
	{
		temp = currLine -> back;
		temp -> info = currLine -> back -> info;
		delete currLine;
		currLine = new LineNode;
		currLine = temp;
		currLine -> back = temp -> back;
		currLine -> info = temp -> info;
		currLine -> next -> info = bottomMessage;
		if (this -> getLength() > 1)
		{
			currLineNum--;
		}
		length--;
		
	}//End else if

	else if (currLine -> back -> info == topMessage && this -> getLength() == 0)
	//Case to account for when currLine is the first line and the linelist is empty
	{
		cout << this -> getCurrLineNum() << "> Error: The File is empty. Please insert a line or save." << endl;
	}

	else
	//Case to account for when the line being deleted is not the top/bottom most line
	{
		temp = currLine -> next;
		temp -> info = currLine -> next -> info;
		temp -> back = currLine -> back;
		temp -> back -> next = currLine -> back;
		delete currLine;
		currLine = new LineNode;
		currLine = temp;
		currLine -> back = temp -> back;
		currLine -> back -> next = currLine;
		currLine -> next = temp -> next;
		currLine -> next -> back = currLine;
		currLine -> info = temp -> info;
		
		if (this -> getLength() > 1) //Instance to catch whether the length is one. If it is, dont decrease the line number
		{
			currLineNum--;
		}
		length--;
		

	}//End else

}//End deleteLine()

void LineList::printList() 
{
	int place = this -> getCurrLineNum(); //save the line number that the user is on so that it can be returned to it again after printing
	this->goToTop();
	if (currLine -> next -> info != bottomMessage)
	{
		if (currLine -> info == topMessage)
		//If currLine is pointing at the topMessage
		{
			this -> moveNextLine();
			currLineNum--;
		}
		
		for (int i = 1; i < this -> getLength(); i++)
		{
			cout << this -> getCurrLineNum() << ">" << " " << currLine -> info << endl;
			currLine = currLine -> next;
			currLineNum++;
		}
		cout << this -> getCurrLineNum() << ">" << " " << currLine -> info << endl;
	}//End if 
	else if (currLine -> next -> info == bottomMessage && this -> getLength() == 1)
	//Case to print the only line in a LineList of size 1
	{
		cout << this -> getCurrLineNum() << ">" << " " << currLine -> info << endl;
	}

	//Code to bring the current pointer back to the spot where the user left off before printing the list
	if (this -> getCurrLineNum() !=  place)
	{
		while (this -> getCurrLineNum() !=  place)
		{
			currLine = currLine -> back;
			currLineNum--;
		}
	}

}//End printList()

string LineList::getCurrLine() const
{
	return currLine -> info;
}//End getCurrLine()

void LineList::moveNextLine()
{
	// Post : Advances currLine (unless already at last line)
	if (currLine -> next -> info != bottomMessage){
	currLine = currLine -> next;
	currLineNum++;
	}

}//End moveNextLine()

void LineList::movePrevLine()
{
	// Post : Advances currLine (unless already at last line)
	if (currLine -> back -> info != topMessage)
	{
		currLine = currLine -> back;
		currLineNum--;
	}//End if 
}//End movePrevLine()

int LineList::getCurrLineNum() const
{
	return currLineNum;
}//End getCurrLineNum()

int LineList::getLength() const
{
	return length;
}//End getLength()
