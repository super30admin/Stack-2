
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;

class Main {
    // approch 1 using stacks
    public static boolean isValid(String s) {
        // null case and odd length
        if (s == null || s.length() == 0)
            return true;
        int n = s.length();
        // stack for getting top startting parenthesis
        Stack<Character> st = new Stack<>();
        // go over all the chars in a string
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // check char is
            if (c == '(')
                st.push(')');
            else if (c == '{')
                st.push('}');
            else if (c == '[')
                st.push(']');
            else if (st.isEmpty() || st.pop() != c)
                return false;
        }
        // at the end we check if stack is empty or not
        // if not return false else return true;
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "((){}[])";
        System.out.println(isValid(s));
    }
}