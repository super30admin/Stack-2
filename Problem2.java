//Time = O(n), length of input string
//Space = O(n)

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); // Initialize a stack to store opening brackets
        for (char c : s.toCharArray()) { // Iterate over each character in the string
            if (c == '(' || c == '[' || c == '{') { // If the character is an opening bracket
                stack.push(c); // Push it onto the stack
            } else { // If the character is a closing bracket
                if (stack.isEmpty()) { // If the stack is empty, return false (no matching opening bracket)
                    return false;
                }
                char top = stack.pop(); // Pop the top character from the stack
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    // If the top character is not the matching opening bracket, return false
                    return false;
                }
            }
        }
        return stack.isEmpty(); // If the stack is empty, all brackets have been matched
    }
}
