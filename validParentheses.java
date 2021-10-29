// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class validParentheses {
    public boolean isValid(String s) {
		
        Stack<Character> stack = new Stack<>();
        char[] sCharArr = s.toCharArray();
        for(char c : sCharArr) {
            
            if(c == '(')
                stack.push(')');
            
            else if(c == '{')
                stack.push('}');
            
            else if(c == '[')
                stack.push(']');
            
            else if(stack.isEmpty() || c!= stack.pop()) 
                    return false;
            }
        
        return stack.isEmpty(); 
        
     }
}
