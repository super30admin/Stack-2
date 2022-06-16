/* 
    Time Complexity                              :  O(N) - time to iterate over the array
    Space Complexity                             :  O(N) - if all are open brackets then all of them will be stored in the stack.
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std; 

// https://leetcode.com/problems/valid-parentheses/

class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        for(int i=0;i<s.size();i++) {
            if(s[i] == '(' or s[i] == '{' or s[i] == '[') {
                st.push(s[i]);
            } else if (s[i] == ')' and !st.empty() and st.top() == '(') {
                st.pop();
            } else if (s[i] == '}' and !st.empty() and st.top() == '{') {
                st.pop();
            } else if (s[i] == ']' and !st.empty() and st.top() == '[') {
                st.pop();
            } else {
                return false;
            }
        }
        
        return st.empty();
    }
};