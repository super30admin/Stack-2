// Time Complexity : O(Length of the string)
// Space Complexity : O(Length of the string)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isValid(String s) {
        // if string length itself is odd, then it can not be a valid one
        if(s.length()%2 != 0) return false;
        Stack<Character> st = new Stack<>();
        // at every opening symbol, we push in the closing
        // as soon as we traverse on closing symbol, we check it with the top of stack
        // if matching, we remove it from stack and keep traversing
        // else return false
        for(int i=0;i<s.length();i++) {
            char curr = s.charAt(i);
            if(curr == '(') st.push(')');
            else if(curr == '[') st.push(']');
            else if(curr == '{') st.push('}');
            else if(st.isEmpty() || curr != st.pop()) return false;
        }
        return st.isEmpty();
    }
}