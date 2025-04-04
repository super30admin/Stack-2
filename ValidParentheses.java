import java.util.Stack;
//TC-O(s.length()) SC-O(1)

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stk.push(')');
            }
            if (c == '[') {
                stk.push(']');
            }
            if (c == '{') {
                stk.push('}');
            }
            if (c == ')' || c == ']' || c == '}') {
                if (stk.isEmpty() || stk.pop() != c) {
                    return false;
                }
            }


        }
        return stk.isEmpty();
    }
}
