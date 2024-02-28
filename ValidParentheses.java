/* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(n)
* 
*/

import java.util.Stack;

class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);

            if (ch == '{') {
                st.push('}');
            } else if (ch == '[') {
                st.push(']');
            } else if (ch == '(') {
                st.push(')');
            } else {
                if (st.isEmpty() || st.peek() != ch) {
                    return false;
                }
                st.pop();
            }
        }

        return st.isEmpty();
    }
}