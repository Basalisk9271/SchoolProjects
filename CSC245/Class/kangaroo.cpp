//Kangaroo Words - Pre Class project
//Written by Gabe Imlay
//Written 1/4/2022

#include <iostream> 
#include <vector> 
#include <cstdlib> 
#include <algorithm>
#include <list>
#include <string>

using namespace std; 

int main()
{
    list<string> mlist;

    cout << "Welcome to Kangaroo Words\n\nEnter the number of pairs: ";
    int numWords;
    cin >> numWords;
    //cout << "There are " << numWords*2 << " words" << endl;
    string word;

    for (int i = 0; i < numWords*2; i++)
    {
        cin >> word;
        mlist.push_back(word);
    }

    for (int j = 0; j<mlist.size();j++)
    {
        cout<<mlist.<<endl;
    }

}