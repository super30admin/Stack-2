20. Valid Parentheses

TC O(n)
SC O(n)


#include <bits/stdc++.h> 

class Solution {
public:
    
    bool is_open (char c) {
        if ((c == '(') || (c == '{') || (c == '['))
           return true; 
        else
            return false;
    }
    
    bool is_close(char c) {
        if ((c == ')') || (c == '}') || (c == ']'))
            return true;
        else 
            return false;
    }
    
    bool is_match (char a, char b) {
        if (((a == '(') && (b == ')')) || ((a == '{') && (b == '}')) || ((a == '[') && (b == ']'))) {
            return true;
        }
        else return false;
    }
    
    bool isValid(string str) {
        stack <char> s;
        char x;
        
        for (int i=0; i< str.size(); i++) {
            if (is_open(str[i])) {
                s.push(str[i]);
                if(s.empty())
                    return false;
            }
            if (is_close(str[i])) {
                 if(s.empty())
                    return false;               
                char c = s.top();
                s.pop();
                if (!is_match(c, str[i]))
                    return false;       
                } else 
                    continue;
            }

        return (s.empty());
        } 
};


#include <bits/stdc++.h> 
#include <stdio.h>
#include <string.h>

class Solution {
public:
bool isValid(string str) {
    int n = str.size();
    if (n == 0) return true;
    if (str.size()%2 != 0) return false;
    stack<char> s;
    for(int i=0; i < str.size(); i++) {
        char c = str.at(i);
        if(c == '{') s.push('}');
        else if (c == '[') s.push(']');
        else if (c == '(') s.push(')');
        else if ((s.size() == 0)|| (c != s.top())) return false; //s.size() is 0 when we have only closing brackets.
        else if (c == s.top()) s.pop();
    }
    if (s.size() != 0) {
        return false;
    }
    return true;
}
};
