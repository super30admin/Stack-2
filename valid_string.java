// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)return true;
        if(s.length() % 2 != 0)return false;
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '[')
                stack.push(']');
            else if(ch == '{')
                stack.push('}');
            else if(ch == '(')
                stack.push(')');
            else{
             if(stack.isEmpty() || stack.peek() != ch)
                 return false;
            
            stack.pop();
            }
    }
     
    return(stack.isEmpty());       
        
    }
}