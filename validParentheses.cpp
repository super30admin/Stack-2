// Time Complexity : O(n)   
// Space Complexity : O(n); stack
// Did this code succesfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Go thru input string, if its an opening brace then add to stack
// 2. If it is a closing brace then if stack is empty or it doesn't match to top of stack then return false; else pop from stack
// 3. Finally, if stack is empty return true else return false (unresolved opening braces) 

class Solution {
public:
    bool isPair(char open, char close){
        if(open=='{' && close == '}' || open=='(' && close == ')' || open=='[' && close == ']')
            return true;
        return false;
    }
    
    bool isValid(string s) {
        if(s.size()==0)
            return true;
        stack<char> st;
        for(auto c:s){
            if(c=='{' || c=='(' || c=='[')
                st.push(c);
            else if(c=='}' || c==')' || c==']'){
                if(st.empty() || isPair(st.top(), c) == false)
                    return false;
                st.pop();
            }
        }
        if(st.empty())
            return true;
        else
            return false;
        return false;
    }
};