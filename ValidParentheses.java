import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        final Stack<Character> stack = new Stack<>();

        for (char ch: s.toCharArray()) {
            switch (ch) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (stack.isEmpty() || stack.peek() != ch) return false;
            }
        }

        return stack.isEmpty();
    }
}
