// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: We maintain a stack that holds the complement of each opening bracket i.e. the corresponding closing bracket
// 2: When we encounter a closing bracket, we ensuret that the top of the stack matches the current character we have
// 3: If the top of the stack does not match the current character, or if we still have elements in the stack after iteration, we return false
class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        if(n%2 != 0) return false;

        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                if (ch == '(')
                    st.push(')');
                else if (ch == '[')
                    st.push(']');
                else if (ch == '{')
                    st.push('}');
            } else {
                if (st.isEmpty() || st.pop() != ch)
                    return false;
            }
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}