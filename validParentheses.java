//TC: O(n) where n is the length of the string given
//SC : O(n)

//CODE

class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // if we have opening brackets then we need to push the corresponding closing
            // brackets into the stack and pop from stack if incoming character is equal to
            // peek ele at stack
            if (c == '(')
                st.push(')');
            else if (c == '[')
                st.push(']');
            else if (c == '{')
                st.push('}');
            else if (st.isEmpty() || st.pop() != c)
                return false; // if stack becomes empty or the peek ele at stack which needs to be popped is
                              // not equal to incoming ch then return false
        }
        if (!st.isEmpty())
            return false;
        return true;
    }
}