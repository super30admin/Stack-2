// Approach: Create a static hashmap of all the opening and closing brackets and maintain
// a stack of all the characters in the i/p string. If next char is a valid opening bracket push in stack
// else if next char is a closing bracket and complementary opening bracket found on top of stack, pop().
// At last, return if the stack is empty
// Time: O(n)
// Space: O(n)

import java.util.*;

class ValidParenthesis {
    public boolean isValid(String s) {

        Map<Character, Character> map = Map.of('(', ')', '{', '}', '[', ']');
        Stack<Character> stack = new Stack();

        for (int i = 0; i<s.length(); i++) {
            char bracket = s.charAt(i);
            if (map.containsKey(bracket)) {
                stack.push(bracket);
            }
            else if (!stack.isEmpty() && bracket == map.get(stack.peek())) {
                stack.pop();
            }
            else return false;
        }
        return stack.isEmpty();
    }
}