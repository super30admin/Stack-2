/**
 * if we get opening brace put closing in stack. If get closing, pop recent and compare if same of not.
 * TC: O(n)
 * SC: O(n)
 */
class Solution {

    public boolean isValid(String s) {
        char[] input = s.toCharArray();

        if (input.length % 2 != 0) {
            return false;
        }

        Stack<Character> st = new Stack();
        for (char c : input) {
            if (c == '{') {
                st.push('}');
            } else if (c == '(') {
                st.push(')');
            } else if (c == '[') {
                st.push(']');
            } else if (st.isEmpty() || st.pop() != c) {
                return false;
            }
        }
        return st.isEmpty();
    }
}
