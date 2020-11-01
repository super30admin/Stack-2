class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {

                st.push(s.charAt(i));
                continue;
            }

            if (st.empty())
                return false;

            switch (s.charAt(i)) {

                case ')':
                    char c = st.pop();

                    if (c == '[' || c == '{')
                        return false;
                    break;
                case '}':
                    c = st.pop();

                    if (c == '[' || c == '(')
                        return false;
                    break;

                case ']':
                    c = st.pop();

                    if (c == '(' || c == '{')
                        return false;
                    break;
            }
        }

        if (st.empty())
            return true;
        return false;
    }
}