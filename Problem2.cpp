// Time Complexity : O(n)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Valid Parantheses

#include<iostream>
#include<vector>
#include<stack>

using namespace std;


class Solution {
public:
    bool isValid(string str) {
        
        stack<char> para;
        for(int i = 0; i < str.length(); i++){
            if(str[i] == '(' || str[i] == '[' || str[i] == '{'){
                para.push(str[i]);
            }
            else{
                if(para.empty())
                    return false;
                if(str[i] == ')' && para.top() != '(')
                    return false;
                if(str[i] == ']' && para.top() != '[')
                    return false;
                if(str[i] == '}' && para.top() != '{')
                    return false;
                
                para.pop();
            }
        }
        
        return para.empty();
        
    }
};