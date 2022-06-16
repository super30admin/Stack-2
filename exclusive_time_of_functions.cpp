/* 
    Time Complexity                              :  O(N) - iterating over the logs array. the splitString doesn't add to time complexity since the string is of fixed length
    Space Complexity                             :  O(N) - in the worst case, all the functions can be a strat function and will be stored in the stack.
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/exclusive-time-of-functions/

class Node {
public:
    int id, ts;
    string exe;
    Node(int i, int t, string e) {
        id = i;
        ts = t;
        exe = e;
    }
};

class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        stack<Node*> st;
        vector<int> ans(n,0);
        int m = logs.size();
        
        if(n == 1 and m == 1) {
            return vector<int>(1,0);
        }
        
        int prevTs;
        string prevExe;
        
        for(int i=0;i<m;i++) {
            
            Node *node = splitString(logs[i]);
            if(node->exe == "start") {
                st.push(node);
            } else {
                if(st.top()->id != node->id) 
                    break;
                
                int tsDiff = node->ts - st.top()->ts + 1;
                ans[node->id] += tsDiff;
                st.pop();
                
                if(!st.empty()) {
                    if(st.top()->exe != "start")
                        break;
                    ans[st.top()->id] -= tsDiff;
                }
                
            }
            
        }
        
        return ans;
    }
    
    Node* splitString(string str) {
        int sz = str.size();
        string s="";
        Node *newNode = new Node(-1,-1,"");
        int idx=0;
        for(int i=0;i<sz;i++) {
            if(str[i] != ':') {
                s += str[i];
            } else {
                if(idx++ == 0) 
                    newNode->id = stoi(s);
                else
                    newNode->exe = s;
                s = "";
            }
            
            if(i == sz-1) {
                newNode->ts = stoi(s);
            }
        }
        
        
        return newNode;
    }
};