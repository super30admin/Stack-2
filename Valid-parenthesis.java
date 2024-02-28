// Time Complexity : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using stack - checking if the char in string is opening paren, then push closing 
// in stack. If we encouter closing pop it from stack and check if both are same.

// 20. Valid Parentheses

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(')');
            }
            else if(c == '['){
                st.push(']');
            }
            else if(c == '{'){
                st.push('}');
            }
            else{
                if(st.isEmpty() || st.pop() != c) return false;
            }
        }
        if(st.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}