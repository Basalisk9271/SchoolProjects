using namespace std;
#include "bst.h"

int main()
{
    BinarySearchTree<int> t(0); 
    t.insert(6);
    t.insert(2);
    t.insert(8);
    t.insert(1);
    t.insert(4);
    t.insert(3);
    t.insert(9);
    /*t.insert(6);
    t.insert(5);
    t.insert(4);
    t.insert(3);
    t.insert(2);
    t.insert(1);*/

    //t.printTree();
    //t.postOrder();
    cout <<"Height of the Tree: " << t.Height() << endl;
    cout <<"Number of Leaves: " << t.numLeaves() << endl;
    string bal = (t.isBalanced() == true) ? "It's Balanced!":"It's not Balanced!";
    cout << "Is the tree Balanced: " << bal << endl;

    
}//End main()