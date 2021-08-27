// TC: O(n)
// SC: O(n)

class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(c == '{') {
                st.push('}');
            }else if(c == '[') {
                st.push(']');
            } else if(c == '(') {
                st.push(')');
            } else if(st.isEmpty() || st.peek() != c) {
                return false;
            } else {
                st.pop();
            }
        }
        return st.isEmpty();
    }
}