/*
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
create hash map of opening and closing brackets.
if you find any openign bracket, you push hta onto the stack,
if you find the closing bracket, match the corresponding opening bracket with the stack.top()
if ture continue else reutrn false
At end check if stack is empty or not. If empty send true or else false
*/

//using stack

#include<iostream>
#include<vector>
#include<unordered_map>
#include<stack>

using namespace std;

class Solution {
public:
    bool isValid(string s) {
        stack<char> st{};
        unordered_map<char,char> umap{
            {'}','{'},
            {')','('},
            {']','['}
        };
        for(char c:s){
            if(c == '{' || c == '[' || c == '('){
                st.push(c);
            }
            else if(st.empty()==false && (c == '}' || c == ']' || c == ')')){
                char gg = st.top();
                st.pop();
                cout<<gg<<" ";
                cout<<umap[c]<<" "<<endl;
                if(gg!=umap[c]){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return st.empty();
    }
};
