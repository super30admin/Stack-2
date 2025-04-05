//time complexity:o(n)

//space complexity :o(n)

//idea is to push closing bracket into stack if corresponding opening bracket in string. and if closing bracket in string then remove it from stack.

// at the end return stack.isEmpty.

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(')');
            } else if (c == '{') {
                st.push('}');
            } else if (c == '[') {
                st.push(']');
            } else if (st.isEmpty() || c != st.pop()) {
                return false;
            }
        }
    if (!st.isEmpty()) return false;
    return true;
    }
}
