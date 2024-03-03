import java.util.Stack;

public class ValidParentheses {
    // TC: O(N) where N is length of string
    // SC: O(N) where N is length of string
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == '(' || currChar == '[' || currChar == '{') {
                stack.push(currChar);
            } else if (currChar == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (currChar == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (currChar == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
