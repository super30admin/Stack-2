//Time Complexity O(n)
// Space Complexity O(n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;

class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        vector<int> result(n,0);
        stack<int> s;
        int prev=0;
        for(auto & log : logs)
        {
            vector<string> logArray = split(log);
            int curr=stoi(logArray[2]);
            if(logArray[1]=="start")
            {
                if(!s.empty())
                {
                    result[s.top()]+=curr-prev;  
                }
                prev=curr;
                s.push(stoi(logArray[0]));
            }
            else
            {
                result[s.top()]+=curr+1-prev;
                prev=curr+1;
                s.pop();
            }
        }
        return result;
    }
    
    vector<string> split(string s)
    {
        vector<string> result;
        string temp="";
        for(auto &c : s)
        {
            if(c==':')
            {
                result.push_back(temp);
                temp="";
            }
            else
            {
                temp+=c;
            }
        }
        result.push_back(temp);
        return result;
    }
    
};