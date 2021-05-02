//TC: O(n)
//SC: O(n/2) since we only add the open brackets to the stack


class Solution {
public:
    bool isValid(string s) {
        
        stack<char> st;
        
        for(int i=0; i<s.length(); i++){
            
            //only push the opening braces to the stack
            if(s[i] == '(' || s[i] == '[' || s[i] == '{')
                st.push(s[i]);
            
            else{
                if(st.empty())
                    return false;
                
                if(s[i] == '}' && st.top()!= '{')
                    return false;
                if(s[i] == ']' && st.top()!= '[')
                    return false;
                if(s[i] == ')' && st.top()!= '(')
                    return false;
                st.pop();
            }
        }
        
        return st.empty();
        
        
    }
};