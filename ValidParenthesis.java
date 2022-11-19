//Time Complexity: O(N)
//Space Complexity:  O(N)
class Solution {
    public boolean isValid(String s) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        Stack<Character> st = new Stack<>();

        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else if (c == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(c);
                }
            } else if (c == ']') {
                if (!st.isEmpty() && st.peek() == '[') {
                    st.pop();
                }  else {
                    st.push(c);
                }
            } else if (c == '}') {
                if (!st.isEmpty() && st.peek() == '{') {
                    st.pop();
                }  else {
                    st.push(c);
                }
            }
        }

        if (st.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
}
