// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(')');
            } else if (c == '{') {
                st.push('}');
            } else if (c == '[') {
                st.push(']');
            }
            // if peek is not matching with incoming element, that means parenthesis is
            // unbalanced
            else if (st.isEmpty() || c != st.pop()) {
                return false;
            }
        }

        return st.isEmpty();
    }
}