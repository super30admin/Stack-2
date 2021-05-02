// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Push corresponding closing brace when an opening brace is encountered, 
//pop when the peek==curr element, if stack is empty then return true.

class Solution {
    public boolean isValid(String s) {
        //sanity check
        if(s == null || s.length() == 0){
            return true;
        }
        if(s.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(ch == '[')
                stack.push(']');
            else if(ch == '(')
                stack.push(')');
            else if(ch == '{')
                stack.push('}');
            else{
                if(stack.isEmpty() || stack.peek() != ch){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
                
            
        }
        return stack.isEmpty();
        
    }
}