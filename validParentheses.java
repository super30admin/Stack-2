// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
 * 1. Iterate over the string and add the closing brackets to the stack.
 * 2. If the stack is empty or the current character is not equal to the popped character, return false.
 * 3. If the stack is empty, return true.
 * 4. Else return false.
 */
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(')');
            }else if(ch == '['){
                st.push(']');
            }else if(ch == '{'){
                st.push('}');
            }else if(st.isEmpty() || ch != st.pop()){
                return false;
            }
        }

        return st.isEmpty();
    }
}