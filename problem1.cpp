/*
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
push == start.
if push then if stack not empty then add time for the current id at the top of the stack to its result array id untill the time
new process is about to start.
if stack is empty then dont
push the process id into stack and update the current time step.

pop == end.
if a process ends then add time untill the end time from previous time step for the current process id
pop the id from the stack and update the time step.
*/

#include<vector>
#include<string>
#include<iostream>
#include<stack>

using namespace std;

class Solution {
    void display(vector<string>& res){
        for(string& s:res){
            cout<<s<<" ";
        }
        cout<<endl;
    }

    vector<string> split_string(string& s){
        vector<string> res{};
        string temp{};
        for(auto&c:s){
            if(c==':'){
                res.push_back(temp);
                temp = "";
                continue;
            }
            temp+=c;
        }
        res.push_back(temp);
        return res;
    }

    int str_num(string& s){
        int val{};
        for(auto& c:s){
            val = val*10 + (c-48);
        }
        return val;
    }

public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        vector<int> res(n,0);
        stack<int> st1{};
        //stack<int> st2{};
        int temp{};
        for(string s:logs){
            vector<string> split = split_string(s);
            if(split.at(1) == "start"){
                int val1 = str_num(split.at(0));
                int val2 = str_num(split.at(2));
                if(st1.empty() == false){
                    //cout<<val2 - st2.top();
                    //res.at(st1.top()) += (val2 - st2.top());
                    res.at(st1.top()) += (val2 - temp);
                    //st2.pop();
                }
                st1.push(val1);
                //st2.push(val2);
                temp = val2;
            }
            else if(split.at(1) == "end"){
                int val1 = str_num(split.at(0));
                int val2 = str_num(split.at(2));
                //since last top stack value will be of the last processed call.
                //res.at(val1) += (val2 - st2.top()+1);
                res.at(val1) += (val2 - temp + 1);
                //st2.pop();
                st1.pop();
                //st2.push(val2+1);
                temp = val2+1;
            }
        }
        return res;
    }
};