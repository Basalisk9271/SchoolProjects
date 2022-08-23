//Lab #1 - Introduction to C++; Convert Fahrenheit to Celsius

#include <fstream> 
#include <iostream> 
#include <string> 
using namespace std;

void print();
double convert(double value);    // function prototype

int main () //Runs the program to prompt for a celsius value and return a message stating the fahrenheit
{
    // Main Program Goes Here
    print();
    return 0;
}

void print ()
{
    double celsius; 
    cout << "Please enter a Celsius Value: ";
    cin >> celsius;
    cout << celsius << " degrees Celsius is " << convert(celsius) << " Fahrenheit" << endl;
}

double convert(double tmp)
{
    return (tmp*1.8)+32.0; //Formula for converting from celsius to fahrenheit
}
