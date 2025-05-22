// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Approach:
// Push the expected closing bracket for every opening bracket to a stack.
// For every closing bracket, check if it matches the top of the stack.
// When all brackets match correctly, the stack will be empty at the end otherwise return false.

import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){ st.push(')');}
            else if(c=='{'){ st.push('}');}
            else if(c=='['){ st.push(']');}
            else if(st.isEmpty()||c!=st.pop()){return false;}
        }
        return st.isEmpty();
    }
}