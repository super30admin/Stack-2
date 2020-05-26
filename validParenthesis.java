// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(Character c: s.toCharArray())
        {
            if(c=='(' || c=='[' || c=='{')
            {
                st.push(c);
            }
            else
            {
                if(st.isEmpty()) return false;
                Character popped = st.pop();
                if(c==')')
                {
                    if(popped!='(') return false;
                }
                else if(c==']')
                {
                    if(popped!='[') return false;
                }
                else
                {
                    if(popped!='{') return false;
                }
            }
        }
        return st.isEmpty();
    }
}class validParenthesis {
    
}