// Time Complexity : O(n) because we traverse the string once
// Space Complexity : O(n) for the stack in the worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use a stack to track the expected closing brackets.
// For every opening bracket, we push its matching closing bracket onto the stack.
// For every closing bracket, it must match the top of the stack, otherwise the string is invalid.

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // push expected closing bracket
            if(ch == '(') {
                st.push(')');
            } else if(ch == '{') {
                st.push('}');
            } else if(ch == '[') {
                st.push(']');
            }

            // closing bracket must match
            else if(st.isEmpty() || ch != st.pop()) {
                return false;
            }
        }

        return st.isEmpty();
    }
}