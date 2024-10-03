//time: O(n)
//space: O(n)
class Solution {
public:
    bool isValid(string s) {
        stack<char> stk;
        for(char c : s) {
            if(c == '(') {
                stk.push(')');
            }
            else if(c == '{') {
                stk.push('}');
            }
            else if(c == '[') {
                stk.push(']');
            }
            else {
                if(stk.empty() || c != stk.top()) {
                    return false;
                }
                stk.pop();
            }
        }
        if(!stk.empty()) {
            return false;
        }
        return true;
    }
};