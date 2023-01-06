// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//iterate thtrough the characters in the string and check the required
//push the alternate bracket to the stack if its opening 
//else pop and compare 
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                st.push(')');
            else if (ch == '[')
                st.push(']');
            else if (ch == '{')
                st.push('}');
            else if (!st.isEmpty() && st.peek() == ch)
                st.pop();
            else
                return false;
        }
        if (st.isEmpty())
            return true;
        return false;
    }
}