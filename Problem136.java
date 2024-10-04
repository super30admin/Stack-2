//TC: O(n)
//SC: O(n)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        // Traverse the string
        for (char c : s.toCharArray()) {
            // Push opening brackets onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // Check for closing brackets and matching with stack's top
            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } 
            else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } 
            else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } 
            else {
                // If it's an unmatched closing bracket or the stack is empty
                return false;
            }
        }
        
        // If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }
}
