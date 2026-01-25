import java.util.Map;
import java.util.Stack;

/**
 * Approach 2: Use stack to store opening brackets.
 * When an end bracket is encountered, we are expecting top / popped element of stack
 * to be its corresponding opening bracket. Else the input is invalid.
 * If all the opening brackets have closing bracket then input is valid and will be empty at the end.
 * If the stack is not empty at the end, the input is invalid. Return false.
 */
// TC: O(N)
// SC: O(N) for stack
class Solution {
    // Map the closing bracket to its corresponding opening bracket
    private static final Map<Character, Character> CLOSING_TO_OPENING_BRACKET_MAP =
        Map.of(
            ')', '(',
            '}', '{',
            ']', '['
        );
    public boolean isValid(String s) {
        Stack<Character> openBracketStack = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char bracket = s.charAt(i);
            if (!CLOSING_TO_OPENING_BRACKET_MAP.containsKey(bracket)) {
                // Push open bracket to the stack.
                openBracketStack.push(bracket);
                continue;
            }
            if (openBracketStack.isEmpty()) {
                // Invalid: Closing bracket occurred before opening bracket.
                return false;
            }
            if (CLOSING_TO_OPENING_BRACKET_MAP.get(bracket) != openBracketStack.pop()) {
                // Invalid: Opening and closing brackets are not of same type.
                return false;
            }
        }
        // Return true if no brackets are left in the stack. Return false otherwise.
        return openBracketStack.isEmpty();
    }
}