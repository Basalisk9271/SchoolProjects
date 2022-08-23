#include <iostream>
#include <vector>
#include <queue>
#include <cmath>
#include <algorithm>
using namespace std;

int maxStringLength(const vector<string>& v);
string largestString(const vector<string>& v);
char GetChar(string str, int k);
vector<queue<string> > ItemsToQueues (const vector<string>& L, int k);
vector<string> QueuesToArray(vector<queue<int> >& QA, int numVals);
void RadixSort(vector<string>& L, int numDigits);
void PrintVector(const vector<string>& L);
string PadString(string &str, const int len, const char paddingChar);
string removeSpaces(string str);

int main()
{
    string a[] = {"zebra", "apple", "orange", "can", "candy", "a", "top", "pumpkin", "today", "parade"};
    vector<string> v(a, a+10);
    vector<string> pad;
    for (int i = 0; i < v.size(); i++)
    {
        pad.push_back(PadString(v[i], maxStringLength(v), ' '));
    }
    cout << "Unsorted Vector: " << endl;
    PrintVector(pad);
    cout << "Sorted Vector: " << endl;
    RadixSort(pad, maxStringLength(pad));
}

int maxStringLength(const vector<string>& v) //returns the number of digits in the largest integer within a vector
{
    int max = v[0].length();
    for (int i = 1; i < v.size(); i++)
        if (v[i].length() > max)
            max = v[i].length();
    
    //return int(log10(max) + 1);
    return max;
}


char GetChar(string str, int k) //returns the kth char of string
{
    char ch;
    int len = str.length();
    ch = str[len-1-k];

    return ch;
}

vector<queue<string> > ItemsToQueues (const vector<string>& L, int k) //function that returns a vector of queues an sorts each int into a queue based off of the digit being examined
{
    vector<queue<string> > Q(128);
    for(int i = 0; i < L.size(); i++)
    {
        Q[GetChar(L[i], k)].push(L[i]);
    }
    return Q;
        
}

vector<string> QueuesToArray(vector<queue<string> >& QA, int numVals) //
{
    vector<string> L;
    for(int i = 0; i < 128; i++){

        while(!QA[i].empty()){

            L.push_back(QA[i].front());

            QA[i].pop();

        }

    }
    return L;
}

void RadixSort(vector<string>& L, int numDigits) //
{
    vector<queue<string> > QA(128);
    for (int k = 0; k < numDigits; k++)
    {
        QA = ItemsToQueues(L, k);
        L = QueuesToArray(QA, L.size());
        
    }
    PrintVector(L);
}

void PrintVector(const vector<string>& L) //prints the Vector Unaltered
{
    for (int i = 0; i < L.size(); i++)
    {
        string str = L[i];
        str = removeSpaces(str);
        cout << str << " " ;
    }
    cout << "\n" << endl;
}

string PadString(string &str, const int len, const char paddingChar)
{
    if(len > str.size())
        str.insert(str.size(), len - str.size(), paddingChar);
    return str;
}

string removeSpaces(string str)
{
    str.erase(remove(str.begin(), str.end(), ' '), str.end());
	return str;
}

