#include <string>
#include "dsexceptions.h"
#include "BinaryHeap.h"
#include <iostream>

using namespace std;

int main()
{
    BinaryHeap <char> PQ (50);

    for (char i = 65; i < 'K'; i++ )
    {
        //cout << i << endl;
        PQ.insert(i);
    }

    //PQ.deleteMin();
    //PQ.printLtSubtree();
    cout << endl;
    cout << "The height of the Heap is: " << PQ.Height() << endl;
    //cout << "The current max of the Heap is: " << PQ.findMax() << endl;
    //cout << "The current leaves of the Heap are: " << PQ.printLeaves() << endl;
    PQ.printLeaves();

    return 0;
}