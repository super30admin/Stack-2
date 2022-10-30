import java.util.Stack;

/*
## Problem 2: Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)

Time Complexity :   O (n) 
Space Complexity :  O (n)
Did this code successfully run on Leetcode :    Yes (20. Valid Parentheses)
Any problem you faced while coding this :       No
 */
// Input: s = "()[]{}"
// Output: true

class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        char[] c = s.toCharArray();
        for(char ch: c){
            if(ch == '('){
                st.push(')');
            }
            else if(ch == '['){
                st.push(']');
            }
            else if(ch == '{'){
                st.push('}');
            }
            else if (st.isEmpty() || st.pop() != ch)
                return false;
        }
        return st.isEmpty();
    }
}