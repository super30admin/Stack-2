// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

/*
Push the open paranthesis into the stack and pop it when you see a matching closing brace.
Push the closing version of it so you can just compare it while popping
Can't keep counter since the order is also important 
*/


class Solution {
public:
    bool isValid(string s) {
        if(s.length() == 0)
            return true;

        stack<char> stack;
        for(char c: s){
            if(c == '(')
                stack.push(')');
            else if(c == '{')
                stack.push('}');
            else if(c == '[')
                stack.push(']');
            else if (!stack.empty() && c == stack.top())
                stack.pop();
            else return false;
        }

        return stack.empty();
    }
};