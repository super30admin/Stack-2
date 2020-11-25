// Time Complexity : O(n), n is length of string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// maintain a stack of chars, when opening brace, push to stack
// on closing brace kind, check stack top and if matching opening brace exists
// in the end check for stack not empty

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()) 
                    return false;
                
                if(ch==')' && stack.peek()=='(')
                    stack.pop();
                
                else if(ch=='}' && stack.peek()=='{')
                    stack.pop();
                
                else if(ch==']' && stack.peek()=='[')
                    stack.pop();
                
                else return false;
            }
        }
        
        if(!stack.isEmpty()) 
            return false;
        
        return true;
    }
}