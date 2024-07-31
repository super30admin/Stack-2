// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// Initialize Stack: Use a stack to store the expected closing brackets for each opening bracket encountered in the string.
//Iterate Through String: For each character, push the corresponding closing bracket onto the stack if it's an opening bracket, or check if it matches the top of the stack if it's a closing bracket.
//Check Validity: The string is valid if all opening brackets have matching closing brackets in the correct order, indicated by an empty stack at the end.

class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{') {
                stack.push('}');
            } else if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || (stack.peek() != ch)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}