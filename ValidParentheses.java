package Dec22;

import java.util.Stack;

class ValidParentheses {
    public boolean isValid(String s) {
        
        /*
        Time complexity: O(n) because we iterate through all n characters of the string exactly once.
        Space complexity: O(n) because extra space of a stack used which can contain at max all n characters of the given string.
        Approach: Using stack.
       
       
        */
        
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // For every opening bracket, push corresponding closing bracket to stack.
            if (c == '(') {
                st.push(')');
            } else if (c == '{') {
                st.push('}');
            } else if (c == '[') {
                st.push(']');
            } 
        /*  If any character other than any of the opening bracket is encountered in string, there are 2 possibilities:
        1) stack is empty & encountered character is a closing bracket => invalid string => return false.
        2) stack is not empty & encountered character is not the same as the one popped from the stack => invalid string because order of brackets is violated => return false.
        */
            else if (st.isEmpty() || st.pop() != c) {
                return false;
            } 
        }
        
        if (!st.isEmpty()) {
            return false;
        }
        
        return true;
        
    }
}