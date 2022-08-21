// Time Complexity -> O(n)
// Space Complexity -> O(n) for the stack.
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    bool isValid(string s) {
        int l = s.size();
        if(l%2 != 0)
            return false;
        stack<char> st;
        
        for(int i = 0; i < l; i++){
            char curr = s[i];
            if(curr == '(')
                st.push(')');
            else if(curr == '{')
                st.push('}');
            else if(curr == '[')
                st.push(']');
            else{
                if(!st.empty()){
                    char c = st.top(); st.pop();
                    if(c != curr)
                        return false;
                }else
                    return false;
            }
            }
        
        if(!st.empty())
            return false;
        return true;
    }
};