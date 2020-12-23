//Time Complexity : O(n) // n : s.length()
//Space Complexity : O(n) // n : s.length()
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;
import java.util.Stack;

class Valid_Parentheses_20 {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{')
                st.push(ch);
            else if(ch == ')' || ch == ']' || ch == '}')
            {
                if(!st.isEmpty())
                {
                    char poppedChar = st.pop();
                    if((poppedChar == '(' && ch != ')') || 
                       (poppedChar == '[' && ch != ']') ||
                       (poppedChar == '{' && ch != '}'))
                        return false;
                }
                else if(st.isEmpty())
                	return false;
            }
        }
        if(!st.isEmpty())
            return false;
        else
            return true;
    }
    public static void main(String[] args)
    {
    	Valid_Parentheses_20 para = new Valid_Parentheses_20();
    	System.out.println(para.isValid("(){}[]"));
    	System.out.println(para.isValid("({[]})"));
    	System.out.println(para.isValid("(){}}{"));
    	System.out.println(para.isValid("{"));
    }
}