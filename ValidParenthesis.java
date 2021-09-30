
/*
Time: O(n) where n = s.length()
Space: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class ValidParenthesis {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();

        for (char curr : s.toCharArray()) {
            if (curr == '{')
                stack.push('}');

            else if (curr == '[')
                stack.push(']');

            else if (curr == '(')
                stack.push(')');

            // comes here if curr is a closed bracked
            else if (stack.isEmpty() || stack.pop() != curr)
                return false;

        }

        return stack.isEmpty();

    }

}