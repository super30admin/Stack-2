// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)
            return true;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '(') stack.push(')');
            if(ch == '{') stack.push('}');
            if(ch == '[') stack.push(']');
        
        if(ch == ')' || ch == '}' || ch == ']'){
            if(stack.empty()) 
                return false;
            else if(stack.pop() != ch)
                    return false;
        }
    }
        if(!stack.empty())
            return false;
        
            return true;
    }
}
