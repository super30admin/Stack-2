// Time Complexity: O(N)
// Space Complexity: O(N)
// Passed Leetcode

class Solution {
    public boolean isValid(String s) {
        
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            
            char value = s.charAt(i);
            
            if (value == ')') {
                if (stack.size() == 0 || stack.pop() != '(') {
                    return false;
                }
                
            } else if (value == '}') {
                if (stack.size() == 0 || stack.pop() != '{') {
                    return false;
                }
            } else if (value == ']') {
                if (stack.size() == 0 || stack.pop() != '[') {
                    return false;
                }
            } else {
                stack.add(value);
            }
            
        }
        
        if (stack.size() == 0)
            return true;
        return false;
        
    }
}