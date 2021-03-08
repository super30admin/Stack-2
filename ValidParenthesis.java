//Problem 135: Valid Parenthesis
//TC:O(N)
//SC:O(N)

//Note:Ask interviewer how many types of brackets are there, if there is only 1 type, then dont use the stack, just use a count variable such as 'open' and 'close'. If at any stage 'close' is greater than 'open' just return false or in end if 'close' is not equal to 'open' then also return false;

import java.util.*;
class Solution135 {
    
    public boolean isValid(String s) {
        
        if(s==null || s.length()==0) return false;
        
        //Without HashMap

        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            
            char ch = s.charAt(i);
            
            if(ch=='(') stack.push(')');
            else if(ch=='{') stack.push('}');
            else if(ch=='[') stack.push(']');
            else if(stack.isEmpty() || stack.pop()!=ch) return false;//if there is a single character i.e "]", so stack empty should be checked otherwise just pop the top one from stack and if it is not equal to the current character then return false;
            
        }
        
        return stack.isEmpty();
    }
    
    //With HashMap
    /*public boolean isValid(String s) {
        
        if(s==null || s.length()==0) return false;
        //TC:O(n),n is s.length || TC: O(n),n is s.length 
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        
        Stack<Character> stack = new Stack<>();
        
        for(char ch:s.toCharArray()){
            
            if(stack.isEmpty() || !stack.peek().equals(map.get(ch))){
                stack.push(ch);
            }else{
                stack.pop();
            }
            
        }
        
        return stack.isEmpty();
        
    }*/
    
    
}