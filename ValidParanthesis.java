/**
 * Uses a stack to track opening brackets and matches each closing bracket in LIFO order.
 * Key idea: the most recent unmatched opening bracket must match the current closing bracket.
 * Time Complexity: O(n), Space Complexity: O(n)
 */
public class ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>(); 

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stk.push(c);
            } else if (stk.isEmpty()) {
                // No opening bracket available to match → invalid
                return false;
            } else {
                char top = stk.pop(); // Always match against the most recent opening bracket

                // Invariant: stack stores only unmatched opening brackets
                // If current closing doesn't match the latest opening → invalid
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        // Valid only if no unmatched opening brackets remain
        return stk.isEmpty();
    }
}