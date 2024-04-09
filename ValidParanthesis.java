// TC: O(n)
// SC: O(n)

// Approach: For every closing bracket check if last added bracket
// was it's counterpart.

import java.util.Stack;

class ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            // closing bracket
            if (stack.isEmpty()) {
                return false;
            }

            if (c == ')' && stack.pop() != '(') {
                return false;
            }

            if (c == ']' && stack.pop() != '[') {
                return false;
            }

            if (c == '}' && stack.pop() != '{') {
                return false;
            }
        }

        return stack.isEmpty();
    }
}