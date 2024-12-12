
Time Complexity (TC): O(n), where n is the length of the string s, as we process each character once.
Space Complexity (SC): O(n) in the worst case, for the stack storing opening brackets.

class Solution {
    public boolean isValid(String s) {
        // iterate through the given string
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}