//t-c: n
//s-c: n
class Solution {
public:
    bool isValid(string s) {
       stack<char> st;
       for(int i = 0; i < s.size(); i++){
            if(!st.empty()){
                if(s[i] == ')'){
                    if(st.top() != '(') return false;
                    st.pop();
                }
                else if(s[i] == '}'){
                    if(st.top() != '{') return false;
                    st.pop();
                }
                else if(s[i] == ']'){
                    if(st.top() != '[') return false;
                    st.pop();
                }
                else 
                    st.push(s[i]);
            }
            else 
                st.push(s[i]);
       }
       if(!st.empty()) return false;
       return true;
    }
};
