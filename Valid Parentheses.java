// Time Complexity: O(n),where n is the length of the string.
// Space Complexity: O(n), where n is the length of the string.

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;

        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == '(')
            {
                st.push(')');
            }
            else if(c == '[')
            {
                st.push(']');
            }
            else if(c == '{')
            {
                st.push('}');
            }
            else if(st.isEmpty() || c!= st.pop())
            {
                return false;
            }
        }

        return st.isEmpty();
    }
}