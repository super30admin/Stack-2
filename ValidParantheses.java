import java.util.Stack;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Did this code successfully run on Leetcode: Yes/No
 * Any problem you faced while coding this: None

 * Approach:
 * Explain your approach here.
 */

public class ValidParantheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c: s.toCharArray()) {
            switch (c) {
                case '(' -> st.push(')');
                case '{' -> st.push('}');
                case '[' -> st.push(']');
                default -> {
                    if (st.isEmpty() || st.peek() != c) {
                        return false;
                    } else {
                        st.pop();
                    }
                }
            }
        }
        return st.isEmpty();
    }
    
    public static void main(String[] args) {
        // Your code here
        ValidParantheses obj = new ValidParantheses();
        boolean result = obj.isValid("(){}[]{}");
        assert(result == true);
    }
}