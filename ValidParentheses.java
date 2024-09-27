// Time complexity: O(N)
// Space complexity: O(N)

import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack st = new Stack ();
        for (int i = 0; i < s.length(); i++)
        {
            
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[')
            {
                st.push(s.charAt(i));
            }
            else 
            {
                if(st.isEmpty())
                {
                    return false;
                }
                char c = (char)st.peek();
                if (c == '{' && s.charAt(i) == '}' || c == '[' && s.charAt(i) == ']' || c == '(' && s.charAt(i) == ')' )
                {
                    st.pop();
                }
                else
                {
                    return false;
                }
                
                
            }
           
        }
        return (st.isEmpty());
        
    }
}