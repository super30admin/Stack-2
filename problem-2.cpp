// https://leetcode.com/problems/valid-parentheses/description/

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public:
        bool isValid(string s) {
            int n = s.length();
            stack<char> st;
            for(int i=0; i<n; i++){
                if(s[i] == '('){
                    st.push(')');
                }
                else if(s[i] == '{'){
                    st.push('}');
                }
                else if(s[i] == '['){
                    st.push(']');
                }
                else{
                    if(st.empty() || s[i] != st.top()) return false;
                    st.pop();
                }
            }
            if(!st.empty()) return false;
            else return true;
        }
    };