// Time Complexity : O(N) # of function id's
// Space Complexity : O(N) size of stack 
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach:
// 1. Write a function to get id,time and start/end. While traversing store id with start time in pair and increase exclusive time for stack top's id by (current time - stack top time). 
// 2. Using stack we store next recursive calls. If current log is end time it's start time is definitely stacks top id. 
// 3. Update this top's id's time with current time after popping stack top pair and updating current id's exclusive time.

class Solution {
public:
    void converter(string s,int &id,int &time,int &fl){
        int ite=0;
        int si=s.size();
        while(s[ite]!=':'){
            id=(id*10)+(s[ite]-'0');
            ite++;
        }
        ite++;
        if(s[ite]=='s'){fl=0;}else{fl=1;}
        while(s[ite]!=':'){ite++;}ite++;
        while(ite<si){
            time=(time*10)+(s[ite]-'0');
            ite++;
        }
    }
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        stack<pair<int,int>> s;
        vector<int> ans(n);
        for(int i=0;i<logs.size();i++){
            int id=0,time=0,fl=0;
            converter(logs[i],id,time,fl);
            cout<<id<<' '<<time<<' '<<fl<<'\n';
            if(fl==0){
                if(!s.empty()){ans[s.top().first]=ans[s.top().first]+ ( time - s.top().second);}
                s.push(make_pair(id,time));
            }else{
                ans[id]=ans[id]+(time-s.top().second )+1;s.pop();
                if(!s.empty()){s.top().second = time+1;}
            }
        }
        return ans;
    }
};