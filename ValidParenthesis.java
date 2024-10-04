import java.util.Stack;

// Use a stack and to put any of the closing braces and whenever you encounter a closing brace, pop it.
// Finally, if stack is empty, given string is valid, else not
// TC: O(n)
// SC: O(n)
class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '(') {
                st.push(')');
            } else if(s.charAt(i) == '{') {
                st.push('}');
            } else if(s.charAt(i) == '['){
                st.push(']');
            } else if(st.isEmpty() || st.pop() != s.charAt(i)) {
                return false;
            }
        }

        return st.isEmpty();
    }
}