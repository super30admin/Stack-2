// Time Complexity : O(n) to iterate over the string
// Space Complexity : O(n) space for stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }
            else if(stack.isEmpty()){
                return false;
            }
            else if(s.charAt(i)==')' && stack.peek()=='('){
                stack.pop();
            }
            else if(s.charAt(i)=='}' && stack.peek()=='{'){
                stack.pop();
            }
            else if(s.charAt(i)==']' && stack.peek()=='['){
                stack.pop();
            }
            else{
                return false;
            }
        }

        if(stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String [] args){
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("(){[]}"));
    }
} 