// Time Complexity: O(n) where n is the length of the string
// Space Complexity: O(n)

class Solution2 {
    public boolean isValid(String s) {
        int l = s.length();
        if( l%2 != 0 ) {
            return false;
        }
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < l; i++) {
            char ch = s.charAt(i);
            if( ch == '(') {
                st.push(')');
            } else if( ch == '[') {
                st.push(']');
            } else if( ch == '{') {
                st.push('}');
            } else if( st.isEmpty() || ch != st.pop() ) {
                return false;
            }
        }
        return st.isEmpty();
    }
}