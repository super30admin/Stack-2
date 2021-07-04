// Time Complexity :O(n) where n in the number elements in the string
// Space Complexity : O(n)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    bool isValid(string st) {
        stack<char> s;
        for(auto c : st){
            if(c == '(') s.push(')');
            else if(c == '{') s.push('}');
            else if(c == '[') s.push(']');
            else if(c == '}' || c == ']' || c == ')'){
                if(s.empty()) return false;
                if(s.top() == c) s.pop();
                else return false;
            }
        }
        if(!s.empty()) return false;
        return true;
    }
};