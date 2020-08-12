// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//https://leetcode.com/problems/valid-parentheses/

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++)
        {
            char currChar = s.charAt(i);
            if(currChar =='{' || currChar =='(' || currChar == '[')
                st.push(currChar);
            
            if(currChar =='}' || currChar ==')' || currChar == ']')
            {
                if(st.empty())
                    return false;
                
                char stChar = st.pop();
                
                switch(currChar)
                {
                    case '}':
                        
                        if(stChar != '{')
                            return false;
                        break;
                    case ')':
                        if(stChar !='(')
                            return false;
                        break;
                    case ']':
                        if(stChar!='[')
                            return false;
                        break;
                }
            }
            
        }
        
        if(!st.empty())
            return false;
        
        return true;
    }
}