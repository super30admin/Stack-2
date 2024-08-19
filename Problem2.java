/*
  LC - 20. Valid Parentheses
  TC - O(n)
  SC - O(n)
*/

class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                st.push(')');
            }
            else if(c == '{') {
                st.push('}');
            }
            else if(c == '[') {
                st.push(']');
            }
            else {
                if(st.isEmpty() || (st.peek() != c)) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }
}