// Time Complexity :O(n) where n in the number elements in the vector
// Space Complexity : O(n) stack size 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        stack<pair<int,int>> stk;
        vector<int> ans(n,0);
        int curr,prev = 0;
        for(auto log : logs){
            stringstream ss(log);
            string temp, temp2, temp3;
            getline(ss, temp, ':');
            getline(ss, temp2, ':');
            getline(ss, temp3, ' ');
            if(temp2 == "start"){
                if(!stk.empty()){
                    ans[stk.top().first] += stoi(temp3) - prev;
                    prev = stoi(temp3);
                }
                stk.push({stoi(temp),stoi(temp3)});
            }
            else{
                ans[stk.top().first] += stoi(temp3) - prev +1;
                prev =stoi(temp3)+1;
                stk.pop();
            }
        }
        return ans;
    }
};