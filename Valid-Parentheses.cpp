// Time Complexity : O(N)
// Space Complexity : O(N)(in a case where there is only open brackets)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    bool isValid(string s) {
        stack<char> open;
        for(int i=0;i<s.length();i++){
            if(s[i]=='('||s[i]=='['||s[i]=='{'){
                open.push(s[i]);
            }
            else{
                if(open.empty()){
                    return false;
                }
                if(s[i]==')'&& open.top()!='('){
                    return false;
                }
                if(s[i]=='}'&& open.top()!='{'){
                    return false;
                }
                if(s[i]==']'&& open.top()!='['){
                    return false;
                }
                open.pop();
            }
        }
        return open.empty();
    }
};
