#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
Each stack element now stores both the function ID and its last recorded time.
On start, we pause the top function and push the new one with its timestamp.
On end, we calculate the duration, pop the function, and update the caller's timestamp.
*/
class Solution{
public:
    vector<int> exclusiveTime(int n, vector<string>& logs){
        stack<pair<int, int>> st;
        vector<int> result(n, 0);

        for(string log : logs){
            size_t p1 = log.find(':');
            size_t p2 = log.find(':', p1 + 1);
            int processId = stoi(log.substr(0, p1));
            string processType = log.substr(p1 + 1, p2 - p1 - 1);
            int curr = stoi(log.substr(p2 + 1));
            
            if(processType == "start"){
                if(!st.empty()){
                    result[st.top().first] += curr - st.top().second;
                }
                st.push({processId, curr});
            }else{
                auto top = st.top(); st.pop();
                result[top.first] += curr - top.second + 1;
                if(!st.empty()) st.top().second = curr + 1;
            }
        }
        return result;    
    }
};
