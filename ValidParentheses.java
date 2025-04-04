import java.util.Stack;
/*
 * TC: O(n) where n is the length of the String
 * SC: O(n)
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') stack.push(c);
            if(c == ')') {
                if(stack.isEmpty() || stack.peek() != '(') return false;
                stack.pop();
            }
            if(c == '}') {
                if(stack.isEmpty() || stack.peek() != '{') return false;
                stack.pop();
            }
            if(c == ']') {
                if(stack.isEmpty() || stack.peek() != '[') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
