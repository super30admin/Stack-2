// TC: O(n)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(n), SC = O(n)
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') st.push(')'); // push the complement
            else if(c == '{') st.push('}');
            else if(c == '[') st.push(']');
            else { // in case of opening brackets
                if(st.isEmpty() || st.peek() != c) return false;
                else st.pop();
            }
        }
        return st.isEmpty();
    }
}