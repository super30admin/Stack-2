// Problem2 Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, when its opening paranthesis push its closing paranthesis into stack. When its closing one check is top element is same as the char.
 * If not return false. If yes move forward and finally return st.isEmpty().
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '{'){
                st.push('}');
            }
            else if(ch == '['){
                st.push(']');
            }
            else if(ch == '('){
                st.push(')');
            }
            else{
                if(st.isEmpty() || st.pop() != ch) return false;
            }
        }
        return st.isEmpty();
    }
}