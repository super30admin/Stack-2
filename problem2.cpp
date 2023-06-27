// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
public:
    bool isValid(string s) {
        stack<char>st;
        int n = s.size();
        for(auto& c:s)
        {
            if(c=='('){
                st.push(')');
            }
            else if(c == '{')
            {
                st.push('}');
            }
            else if(c == '[')
            {
                st.push(']');
            }
            else if(st.empty()){
                return false;
            }
            else
            {
                if(st.top()!=c) return false;
                st.pop();
            }
        }
        return st.empty();
    }
};