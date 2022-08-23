#include <queue>
#include <iostream>

using namespace std;

void insertNames(priority_queue<string>& names);
void printPQ(priority_queue<string>& names);

int main()
{
    priority_queue<string> names;
    insertNames(names);
    printPQ(names);


}

void insertNames(priority_queue<string>& names)
{
    names.push("Josh");
    names.push("Garrett");
    names.push("Ervin");
    names.push("Alex");
    names.push("Seiler");
    names.push("Andy");
    names.push("Walter");
    names.push("Jacob");
    names.push("Leonidas");
    names.push("Michael");
}
void printPQ(priority_queue<string>& names)
{
    while (!names.empty())
    {
        cout << names.top() << endl;
        names.pop();
    }
}