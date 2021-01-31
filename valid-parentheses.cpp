//Time - O(len(s))
//Space - O(len(s))

class Solution {
public:
    bool isValid(string s) {
        
        stack<char> st;
        
        for(auto c:s){
            
            if(st.empty() && (c == '}' || c == ')' || c == ']')) return false;
            
            if(c == '{' || c == '[' || c == '(' ){
                st.push(c);
            }else{
                if(c == '}'){
                    if(st.top()!='{') return false;
                }else if(c == ')'){
                    if(st.top()!='(') return false;
                }else if(c == ']'){
                    if(st.top()!='[') return false;
                } 
                st.pop();
            }
        }
        return st.empty();
    }
};