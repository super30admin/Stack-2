//time complexity: O(n) -> We iterate through the entire string of size n
//space complexity: O(n) -> Push operation take O(n) and in worst case we end up pushing every element from string s 

//Did it work on Leetcode? Yes

//logic

//1. Push all the opening brackets into the stack
//2. For all three brackets, check for corresponding closing brackets 
//3. Handle edge cases [only opening braces pushed, ')' is pushed but '(' is not at the top ]

#include <iostream>
#include <string>
#include <stack>

using namespace std;

class Solution{
    public:

        bool isValid(string s)
        {
            stack<char> myStack;

            for(char c: s)
            {
                if(c == '(' || c == '[' || c == '{') 
                    myStack.push(c);
                else 
                {
                    if(myStack.empty()) return false; //handles cases for junk input
                    if(c == ')' && myStack.top() != '(') return false;
                    if(c == ']' && myStack.top() != '[') return false;
                    if(c == '}' && myStack.top() != '{') return false;
                    myStack.pop();
                    
                }
            }
            return myStack.empty();
        }
};

