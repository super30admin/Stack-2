// Time Complexity : O(N) # of characters in string
// Space Complexity : O(N) size of stack 
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach:
// 1. Check if current char is opening bracket if yes push it in stack.
// 2. If not, check if it's of similar opening type of stack's top element if yes pop current top of stack.
// 3. Else push current closing bracket to stack. If stack is not empty means string is invalid else valid.

class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        for(int i=0;i<s.size();i++){
            if(s[i]=='(' || s[i]=='[' || s[i]=='{'){
                st.push(s[i]);
            }
            else{
                if(st.empty()!=1){
                if(s[i]==')' && st.top()=='('){
                    st.pop();
                }
                else if(s[i]==']' && st.top()=='['){
                    st.pop();
                }
                else if(s[i]=='}' && st.top()=='{'){
                    st.pop();
                }
                else{
                    st.push(s[i]);
                }
                }
                else{
                    return 0;
                }
            }
        }
        if(st.empty()==1){
            return 1;
        }
        else{
            return 0;
        }
    }
};