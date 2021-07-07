#include<iostream>
#include<stack>
using namespace std;

// Time Complexity : O(N) for Stack
// Space Complexity : O(N) for Stack
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
// Your code here along with comments explaining your approach



bool isValid(string s) {
    stack<char> st;
    int size = s.length();
        if(size == 0 )
            return true;
    for(int i =0; i < size; i++){
        if(s[i] == '(') st.push(')');
        else if(s[i] == '{') st.push('}');
        else if(s[i] == '[') st.push(']');
        else if(st.empty() || st.top() != s[i]){
                return false;
        }
        else {
            st.pop();
        }
            
    }
    return st.empty(); 
}

int main(){
    string s= "()";
    cout<<isValid(s);
}