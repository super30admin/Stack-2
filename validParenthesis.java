// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
 * check open branck and if so then push closing bracket in the Stack.
 * if the top element in stack does not match the particular bracket return false.
 */
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        if (s.length() % 2 != 0)
            return false;

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(')');
            } else if (c == '{') {
                st.push('}');
            } else if (c == '[') {
                st.push(']');
            } else if (st.isEmpty() || st.pop() != c) {
                return false;
            }

        }
        if (!st.isEmpty())
            return false;
        return true;
    }
}