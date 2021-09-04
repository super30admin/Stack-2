// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this - 

class Solution {
public:
    bool isValid(string s) {
        
        int len = s.length();
        int i;
        
        stack<char> str_st;
        
        for(i = 0; i < len; i++)
        {
            // Opening
            if(s[i] == '(' || s[i] == '{' || s[i] == '[')
            {
                str_st.push(s[i]);
            }
            // Closing
            else
            {
                // Non Empty stack
                if(!str_st.empty())
                {
                if(str_st.top() == '(' && s[i] == ')')
                    str_st.pop();
                else if(str_st.top() == '{' && s[i] == '}')
                    str_st.pop();
                else if(str_st.top() == '[' && s[i] == ']')
                    str_st.pop();
                // Incorrect matching of parantheses
                else
                    return false;
                }
                // EMpty stack
                else
                    return false;
            }
        }
        
        // True only if stack empty
        if(str_st.empty())
            return true;
        else
            return false;
    }
};