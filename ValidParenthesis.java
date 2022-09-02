import java.util.Stack;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(')');
            } else if (c == '{') {
                st.push('}');
            } else if (c == '[') {
                st.push(']');
            } else if (st.isEmpty() || c != st.peek()) {
                return false;
            } else {
                st.pop();
            }
        }

        return st.isEmpty();

    }
}