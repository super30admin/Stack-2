// Time complexity-O(n)
// space complexity O(n);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// iterating over the array
// if its a start operation push it into the stack
// else pop the top element in the task and calaculate the exclusive time

#include<algorithm>
#include<iostream>
#include <sstream>
#include<vector>
#include<stack>

using namespace std;

class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        if(logs.size()== 0){
            return {};
        }
        int prev=0;
        stack<int>st;
        vector<int>results(n,0);
        for(string log : logs){
            // tokenize the string
            stringstream sstream(log);
            string id;  getline(sstream,id,':');
            string op ; getline(sstream,op,':');
            string end; getline(sstream,end,':');
            
            int curr = stoi(end);
            if(op=="start"){
                if(!st.empty()){
                    results[st.top()]+= curr-prev;
                    prev=curr;
                }
                st.push(stoi(id));
            }else{
                results[st.top()]+= curr-prev+1;
                st.pop();
                prev =curr+1;
            }
        }
        
       return results ;
    }
};