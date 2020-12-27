// Using Stack
// Time Complexity: O(n) n = size of string
// Space Complexity: O(n) max possible size of stack = n
class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        st.push(s[0]);
        for(int i = 1; i < s.size(); i++) {
            if(!st.empty()) {
                if(st.top() == '(' && s[i] == ')')
                    st.pop();
                else if(st.top() == '[' && s[i] == ']')
                    st.pop();
                else if(st.top() == '{' && s[i] == '}')
                    st.pop();
                else
                    st.push(s[i]);
            }
            else {
                st.push(s[i]);
            }
        }
        return st.empty();
    }
};

// Using Stack
// Time Complexity: O(n) n = size of string
// Space Complexity: O(n) max possible size of stack = n
class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        for(int i = 0; i < s.size(); i++) {
            if(s[i] == '(')
                st.push(')');
            else if(s[i] == '[')
                st.push(']');
            else if(s[i] == '{')
                st.push('}');
            else if(st.empty() || st.top() != s[i]) {
                return false;
            }
            else 
                st.pop();
        }
        return st.empty();
    }
};
