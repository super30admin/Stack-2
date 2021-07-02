// Time complexity-O(n)
// space complexity O(n);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// iterating over the string
// if its an opening bracket push into the stack
// else check it the top corresponds with the top element in the stack before popping it
// if stack is empty after iteration return true

#include<algorithm>
#include<iostream>
#include<vector>
#include<stack>
using namespace std;
class Solution {
public:
    bool isValid(string s) {
        
        if(s.size()== 0){
            return false;
        }
        
        stack<char>st;
        
        for(char c : s){
         
               if( c==']' || c=='}' || c==')'){
               
                if(st.empty()){return false;}
                if( c==']' && st.top()!= '[') return false;
                if( c=='}' && st.top()!= '{') return false;
                if( c==')' && st.top()!= '(' )return false;
                st.pop();  
            }
            else{
                st.push(c);
            }
           
        }
        if(st.empty()){return true;}
        return false;
    }
};