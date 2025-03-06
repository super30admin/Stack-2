import java.util.Stack;

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class validParantheses {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stk.push(')');
            } else if (s.charAt(i) == '{') {
                stk.push('}');
            } else if (s.charAt(i) == '[') {
                stk.push(']');
            } else if (stk.isEmpty() || stk.pop() != s.charAt(i)) {
                return false;
            }
        }
        if (stk.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
