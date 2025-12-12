// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/*
Approach
we are using a stack here because of different type of parentheses
or else we have use normal counts

we push every time we see a open parentheses but we push a close parentheses of the
same type so when popping we can directly check
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(')');
            } else if (ch == '{') {
                st.push('}');
            } else if (ch == '[') {
                st.push(']');
            } else if (st.isEmpty() || ch != st.pop()) {
                return false;
            }
        }
        if (!st.isEmpty()) {
            return false;
        }
        return true;
    }
}