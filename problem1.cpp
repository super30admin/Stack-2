/*
Time complexity: O(x*n)
Space complexity: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        vector<int> ans(n,0);
        stack<pair<int,int>> time;
        for(auto x : logs) {
            if(x.find('e') == -1) {
                time.push({0,stoi(x.substr(x.rfind(':') + 1))});
            } else {
                int soFar = time.top().first;
                int start = time.top().second;
                int end = stoi(x.substr(x.rfind(':') + 1));
                time.pop();
                ans[stoi(x.substr(0,x.find(':')))] += end - start - soFar + 1;
                if(!time.empty())
                    time.top().first += end - start + 1;
            }
        }
        return ans;
    }
};