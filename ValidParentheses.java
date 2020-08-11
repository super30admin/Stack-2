// Time Complexity : O(n) --> where n is the length of input string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (20): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValid(String s) {
        // edge case
        if (s == null || s.length() == 0) return true;
        
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') st.push(')');
            else if (c == '{') st.push('}');
            else if (c == '[') st.push(']');
            else if (st.isEmpty() || c != st.pop()) return false;
        }
        if (!st.isEmpty()) return false;
        return true;
    }
}