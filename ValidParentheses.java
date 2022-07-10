/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(')
                    return false;
            } else if (ch == '}') {
                if (stack.isEmpty() || stack.pop() != '{')
                    return false;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[')
                    return false;
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();

    }
}
