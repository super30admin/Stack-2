// In this approach, maintaining a stack, if any opening bracket encountered, pushing its corresponding closing bracket in the stack,
// and when any closing bracket encountered, checking for same bracket at the top of the stack, if found do s.pop else return false
// In end return true if stack is empty else false

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public boolean isValid(String s) {
        // Base case
        if (s.length() == 0 || s == null) {
            return true;
        }
        int n = s.length();
        // Stack
        Stack<Character> s1 = new Stack<>();
        // loop till n
        for (int i = 0; i < n; i++) {
            // Take one char at a time
            char c = s.charAt(i);
            // Check if it is any opening bracket
            if (c == '(') {
                // push it's corresponding closing in stack
                s1.push(')');
            } else if (c == '[') {
                s1.push(']');
            } else if (c == '{') {
                s1.push('}');
            } else {
                // If it is any closing bracket, check on top of stack
                if (!s1.isEmpty() && c == s1.peek()) {
                    // If found same, then pop
                    s1.pop();
                } else {
                    // Else false
                    return false;
                }
            }
        }
        // If stack is empty, return true else false
        return s1.isEmpty();
    }
}