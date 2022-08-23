#include <string>
#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
using namespace std;

void Initialize(vector<int>& v);
void Print(vector<int>& v);
void Reverse(vector<int>& v);

int main()
{
    stack<string> s1, s2;

    s1.push("Hi there");

    s2.push("Hey");

    s2.push("She sells sea shells by the sea shore");

    if (s1 < s2)
        cout << "Stack 2 is greater than Stack 1" << endl;
    else if (s1 > s2)
        cout << "Stack 1 is greater than Stack 2" << endl;
    else 
        cout << "The stacks are equal" << endl;

    vector<int> v;
    Initialize(v);
    cout << "Printed Vector: ";
    Print(v);
    Reverse(v);
    cout << "Reversed Vector: ";
    Print(v);
    sort(v.begin(), v.end());
    cout << "Sorted Vector: ";
    Print(v);
    
    
    return 0;
}

void Initialize(vector<int>& v)
{
    int in = 5;
    int input;
    do{
        cin >> input;
        v.push_back(input);
        in--;
    }while (in != 0);
}

void Print(vector<int>& v)
{
    for (int i = 0; i < v.size(); i++)
        cout << v[i] << " ";
    
    cout << endl;
}

void Reverse(vector<int>& v)
{
    vector<int> temp;
    for (int i = v.size(); i > 0; i--)
        temp.push_back(v[i-1]);
    v.swap(temp);
    
}