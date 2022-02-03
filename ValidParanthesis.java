// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We use stack to solve this problem
// we push the opening braces onto the stack
// whenever we get closing brace we check for the corresponding opening brace on the top of the stack
// if yes we conntinue, else we return false

class Solution {
    public boolean isValid(String s) {
        Stack<Character> para = new Stack();
        if(s.length()%2 != 0)
        return false;

             
        for(int i= 0; i<s.length(); i++){
            
            if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[')
                para.push(s.charAt(i));
            if(s.charAt(i) == '}' ){
                if(!para.empty() && para.peek() == '{')
                    para.pop();
                else 
                    return false;
            }
            if(s.charAt(i) == ')'   ){
                if(!para.empty() && para.peek() == '(')
                    para.pop();
                else
                    return false;
            }
            if(s.charAt(i) == ']' ){
                if(!para.empty() && para.peek() == '[')
                    para.pop();
                else 
                    return false;
            }
        }
            
        return para.empty();
    }