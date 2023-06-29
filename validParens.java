// TC - O(n)
// SC - O(n) for Stack

/*
 * Approach
 * We use a stack to find and evaluate pairs of parenthesis, no matter which
 * order they appear in. If a mismatch occurs, then we immediately exit.
 */

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }

        int n = s.length();
        if(n == 1) return false;

        // use stack to check pairs
        Stack<Character> st = new Stack<>();

        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            switch(c) {
                // opening values
                case '{':
                    st.push('}'); break;
                case '(':
                    st.push(')'); break;
                case '[':
                    st.push(']'); break;
                // closing values
                case '}':
                case ')':
                case ']':
                    if(st.isEmpty() || st.pop() != c) return false;
                    break;
            }
        }

        return st.isEmpty();
    }
}