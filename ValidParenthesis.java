// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(') st.add(')');
            else if (c == '[') st.add(']');
            else if (c == '{') st.add('}');
            else {
                if (st.isEmpty() || c != st.pop()) return false;
            }

        }

        return st.isEmpty();
    }
}