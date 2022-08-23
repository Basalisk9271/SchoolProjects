#include <fstream> 
#include <iostream> 
#include <string> 
 
using namespace std; 
 
int main() 
{ 
        ifstream infile("infile.in"); 
        ofstream outfile("outfile.out"); 
 
        int num; 
        string s; 
 
        while (infile >> num) 
                if (num != 0) 
                        outfile << num << " "; 
                else 
                        break; 
 
        getline(infile, s); 
        outfile << endl << s << endl; 
        return 0; 
} 