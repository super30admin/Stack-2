class ValidParentheses {
    
    // Time Complexity: O(n)    (where n -> length of string)
    // Space Complexity: O(n)
    
    public boolean isValid(String s) {
        // Edge Case Checking
        if(s == null || s.length() == 0)
            return true;
        
        // If string is of odd length -> then we can't have a valid parentheses
        if(s.length() % 2 != 0)
            return false;
        
        Stack<Character> stack = new Stack<>();

        // For every appropriate opening bracket - we push the appropriate closing bracket to the stack
        for(char c : s.toCharArray()){
            if(c == '(')
                stack.push(')');
            else if(c == '{')
                stack.push('}');
            else if(c == '[')
                stack.push(']');
            // Once we get the closing bracket - it should match the character -- otherwise return false
            else{
                if(stack.isEmpty() || stack.peek() != c)
                    return false;
                stack.pop();
            }
        }
        
        // After traversing the string - if the stack is empty - then true else false
        return stack.isEmpty();
    }
}