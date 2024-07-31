//time complexity:o(n)
//space complexity :o(n)

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        int length = s.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < length; i++) {

            char bracket = s.charAt(i);

            if (bracket == '{') {

                stack.push('}');

            } else if (bracket == '[') {

                stack.push(']');

            } else if (bracket == '(') {

                stack.push(')');

            } else if (stack.isEmpty() || stack.peek() != bracket)
                return false;

            else if (stack.peek() == bracket)
                stack.pop();

        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        Solution so = new Solution();
        String s1 = "()[]{}";
        boolean ans = so.isValid(s1);
        System.out.println(ans);
    }
}