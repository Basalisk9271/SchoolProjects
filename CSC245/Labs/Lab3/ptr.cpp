#include <iostream>
#include <cstring>
using namespace std;

struct RecType
{
int age;
float weight;
char gender;
};

int main()
{
    int num = 5;

    int *intPtr;
    intPtr = NULL;
    intPtr = &num;
    *intPtr = *intPtr * 10;
    cout << endl;
    cout << "intPtr points to: \t\t\t\t" << *intPtr << endl;

    RecType *recPtr = new RecType;
    recPtr->age = 25;
    recPtr->weight = 190;
    recPtr->gender = 'M';
     recPtr->age = recPtr->age + 5;
    cout << "Three Fields Pointed to By recPtr: \t\t" << recPtr->age << " " << recPtr->weight << " " << recPtr->gender << endl;
    
    delete recPtr;
    recPtr = NULL;

    char *strPtr = new char[50];
    strcpy(strPtr, "Operating Systems");
    cout << "strPtr points to: \t\t\t\t" << strPtr << endl;

    int count = 0;
    for (int i =0; i < strlen(strPtr); i++)
    {
        if (islower(strPtr[i]))
            count++;
        
    }
    cout << "LowerCase Letters Pointed To By strPtr: \t" << count << endl;
    cout << "Printing strPtr after adding 10: \t\t" << strPtr+10 << endl;
    cout << endl;

    return(0);
}
