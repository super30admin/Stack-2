//time complexity: O(n) -> We iterate through the entire string of size n
//space complexity: O(n) -> Push operation take O(n) and in worst case we end up pushing every element from string s 

//Did it work on Leetcode? Yes

//Comments: I had to modify the class solution as C++ Stack.pop() doesn't allow any return type

#include <iostream>
#include <stack>
#include <string>

using namespace std;

class Solution {
public:
   bool isValid(string s)
   {
       stack<char> myStack;
       
       for(char c: s)
       {
           if(c == '(') myStack.push(')');
           else if(c == '[') myStack.push(']');
           else if(c == '{') myStack.push('}');
           else //whenever the input is not any opening braces 
           {
                if(myStack.empty() || c != myStack.top()) return false; //check for faulty inputs when stack remains empty or when there's no matching braces 
                myStack.pop();
           }
       }
             
       return myStack.empty(); 
   }
};