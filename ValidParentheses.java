import java.util.*;

// O(n) time, O(n) space

class Solution {
    public boolean isValid(String s) {
        if (s.length() == 1) return false;
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                st.push(c);
            }

            else {
                if (st.isEmpty()) return false;

                char ch = st.pop();
                if (ch == '(' && c != ')' || 
                    ch == '{' && c != '}' || 
                    ch == '[' && c != ']') {
                        return false;
                    }
            }
            
        }
        return st.isEmpty();
    }
}