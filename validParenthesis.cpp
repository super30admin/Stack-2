class Solution {
public:
    bool isValid(string s) {
        stack<int> stk;
        int n=s.length();
        for (int i=0;i<n;i++) {
            if (s[i]== '(' || s[i]=='{' || s[i]== '[') {
                stk.push(s[i]);
            } else if ( !stk.empty() && s[i]=='}' && stk.top()=='{') {
                stk.pop();
            } else if ( !stk.empty() && s[i]==']' && stk.top()=='[') {
                stk.pop();
            } else if ( !stk.empty() && s[i]==')' && stk.top()=='(') {
                stk.pop();
            } else {
                stk.push(s[i]);
            }
        }
        if (stk.empty())
            return true;
        return false;
    }
};