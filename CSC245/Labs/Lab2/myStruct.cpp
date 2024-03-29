
#include <iostream>
#include <string> 
using namespace std;

const int SIZE = 100;

struct DateType
{
	string month;
	int day;
	int year;
};

struct EventType
{
	string place;
	DateType date;
};



void PrintStruct (DateType Holiday);
void AssignMonth (EventType Dates[]);

int main()
{
	DateType Holiday;
	Holiday.month = "February";
	Holiday.day = 14;
	Holiday.year = 2022;

	EventType Dates[SIZE];




	PrintStruct (Holiday);
	AssignMonth (Dates);
	//cout << Dates[50].date.month << endl; //test for the assign month function
	return 0;
}

void PrintStruct (DateType Holiday)
{
	// pre  : Holiday is intialized with three field values
	// post : Function prints date of Holiday in form mm dd, yy
 cout<<Holiday.month<<" "<<Holiday.day<<", "<<Holiday.year<<endl;



}

void AssignMonth (EventType Dates[])
{
	// pre  : none 
	// post : The month field of every date record in array is assigned a month 
for (int i = 0; i < 100; i++)
{
	Dates[i].date.month = "February";
}


}
