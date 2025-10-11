#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We push all opening brackets to a stack and pop when we encounter a closing bracket.
If the stack is empty or the top doesn’t match the closing bracket, it’s invalid.
If the string only has one type of parenthesis, a simple count variable (increment on '(', decrement on ')') is enough
*/
class Solution{
public:
    bool isValid(string s){
        stack<char> st;

        for(char c : s){
            if(c == '(' || c == '{' || c == '[') st.push(c);
            else if(st.empty()) return false;
            else if(c == ')' && st.top() != '(') return false;
            else if(c == '}' && st.top() != '{') return false;
            else if(c == ']' && st.top() != '[') return false;
            else st.pop();
        }
        return st.empty();
    }
};