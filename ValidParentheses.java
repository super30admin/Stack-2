// Time Complexity: O(n) where n is the length of the array.
// Space Complexity: O(n) where n is the length of the array.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class ValidParentheses {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char ch = ' ';
            if(!st.isEmpty()) {
                ch = st.peek();
            }
            if(c == '(') {
                st.push(')');
            }
            else if(c == '{') {
                st.push('}');
            }
            else if(c == '[') {
                st.push(']');
            }
            //else if(st.isEmpty() || c != st.pop()) return false;
            else {
                if(c == ch) {
                    st.pop();
                }
                else {
                    return false;
                }
            }
        }
        return st.isEmpty();
        
        
    }
}