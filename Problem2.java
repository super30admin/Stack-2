import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int n = s.length();
        if (n == 1)
            return false;

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            switch (c) {

                case '{':
                    st.push('}');
                    break;
                case '(':
                    st.push(')');
                    break;
                case '[':
                    st.push(']');
                    break;

                case '}':
                case ')':
                case ']':
                    if (st.isEmpty() || st.pop() != c)
                        return false;
                    break;
            }
        }

        return st.isEmpty();
    }
}
