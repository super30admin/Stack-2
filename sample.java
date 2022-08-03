//******135.20. VALID PARANTHESIS*****
// Time Complexity :O(N);
// Space Complexity :O(N);
// Did this code successfully run on Leetcode :Y;
// Any problem you faced while coding this :N;

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        if(s.length()==0) return true;
        
        //If string is odd, for sure it is not the valid paranthesis
        if(s.length()%2!=0) return false;
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            
            if(c=='(')
            {
                st.push(')');
            }
            
            else if(c=='[')
            {
                st.push(']');
            }
            else if(c=='{')
            {
                st.push('}');
            }
            else
            {
                if(st.isEmpty() || st.pop()!=c)
                {
                    return false;
                }
            }
            
            
        }
        
        //Lastly still if stack is not empty that means not valid.
        if(!st.isEmpty())
        {
            return false;
        }
        return true;
        
        
    }
}

// Your code here along with comments explaining your approach
