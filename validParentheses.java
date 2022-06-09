/*
Problem: https://leetcode.com/problems/valid-parentheses/
*/
// Approach 1: Stack
// TC: O(n)
// SC: O(n)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(')');
            } else if (c == '{') {
                st.push('}');
            } else if (c == '[') {
                st.push(']');
            } else {
                if (st.isEmpty() || st.pop() != c) {
                    return false;
                }
            }
        }
        
        return st.isEmpty();
    }
}