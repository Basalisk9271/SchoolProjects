#include <iostream>
#include <vector>
#include <queue>
#include <cmath>
using namespace std;

int maxElemLength(const vector<int>& v);
int GetDigit(int number, int k);
vector<queue<int> > ItemsToQueues (const vector<int>& L, int k);
vector<int> QueuesToArray(vector<queue<int> >& QA, int numVals);
void RadixSort(vector<int>& L, int numDigits);
void PrintVector(const vector<int>& L);

int main()
{
    vector<int> v;
    v.push_back (380);
    v.push_back (95);
    v.push_back (345);
    v.push_back (260);
    v.push_back (100);
    v.push_back (492);
    //cout << "Number of digits in max: " << maxElemLength(v) << endl; 
    //cout << "0 digit in 95 = " << GetDigit(95,2) << endl;
    PrintVector(v);
    cout << "Sorted Vector: " << endl;
    RadixSort(v, maxElemLength(v));
}

int maxElemLength(const vector<int>& v) //returns the number of digits in the largest integer within a vector
{
    int max = v[0];
    for (int i = 1; i < v.size(); i++)
        if (v[i] > max)
            max = v[i];
    
    return int(log10(max) + 1);
}

int GetDigit(int number, int k) //returns the kth digit of number
{
    int digit = number;
    for (int i = k; i > 0; i--)
    {
        digit = digit / 10;
    }

    digit = digit % 10;
    return digit;
}

vector<queue<int> > ItemsToQueues (const vector<int>& L, int k) //function that returns a vector of queues an sorts each int into a queue based off of the digit being examined
{
    vector<queue<int> > Q(10);
    for(int i = 0; i < L.size(); i++)
    {
        Q[GetDigit(L[i], k)].push(L[i]);
    }
    return Q;
        
}

vector<int> QueuesToArray(vector<queue<int> >& QA, int numVals) //
{
    vector<int> L;
    for(int i = 0; i < 10; i++){

        while(!QA[i].empty()){

            L.push_back(QA[i].front());

            QA[i].pop();

        }

    }
    return L;
}

void RadixSort(vector<int>& L, int numDigits) //
{
    vector<queue<int> > QA(10);
    for (int k = 0; k < numDigits; k++)
    {
        QA = ItemsToQueues(L, k);
        L = QueuesToArray(QA, L.size());
    }
    PrintVector(L);
}

void PrintVector(const vector<int>& L) //prints the Vector Unaltered
{
    for (int i = 0; i < L.size(); i++)
    {
        cout << L[i] << " " ;
    }
    cout << endl;
}