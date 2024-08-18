// Time Complexity : 0(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty())
            return true;

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                st.push(')');
            else if (ch == '{')
                st.push('}');
            else if (ch == '[')
                st.push(']');

            else if (st.isEmpty() || ch != st.pop()) {
                return false;
            }
        }

        return st.isEmpty();
    }
}