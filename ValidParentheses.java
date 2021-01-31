// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// As we iterate through the string, if we have a opening bracket
// push the corresponding closing bracket into the stack
// If we have a closing bracket, pop the stack and check if they are same
// If they are not same or stack is empty before we complete iterating
// return false
// After iteration, if stack is not empty, return false


class Solution {
    public boolean isValid(String s) {
        
        if(s == null || s.length() == 0) return true;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            
            if(c == '(') {
                stack.push(')');
            }
            else if(c == '{') {
                stack.push('}');
            }
            else if(c == '[') {
                stack.push(']');
            }
            else if(stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}