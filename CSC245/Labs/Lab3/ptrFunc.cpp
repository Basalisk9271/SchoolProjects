#include <iostream>
#include <cstring>
using namespace std;

bool sameData(double *ptr1, double *ptr2);
bool sameAddress(double *ptr1, double *ptr2);

int main()
{
    double a = 5, b = 5;
    double *dblPtr1 = &a, *dblPtr2 = &b;
    bool sameDat = sameData(dblPtr1, dblPtr2);
    string smDt = (sameDat == true) ? "True":"False";
    bool sameAdd = sameAddress(dblPtr1, dblPtr2);
    string smAd = (sameAdd == true) ? "True":"False";
    cout << "Do the pointers have the same data?\t" << smDt << endl;
    cout << "Do the pointers have the same data?\t" << smAd << endl;
    
}

bool sameData(double *ptr1, double *ptr2)
{
    return ((*ptr1==*ptr2) ? true : false);
}

bool sameAddress(double *ptr1, double *ptr2)
{
    return ((ptr1==ptr2) ? true : false);
}