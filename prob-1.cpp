class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        vector<int> ans(n);
        stack<pair<int,int>> cur;
        int prevTime = 0;
        for (auto& s : logs){
            int num = stoi(s.substr(0, s.find(':')));
            int time = stoi(s.substr(s.rfind(':') + 1));
            if (s.find('e') != -1){
                ans[num] += time - prevTime + 1;
                cur.pop();
                prevTime = time + 1;
            }
            else{
                if (!cur.empty()) ans[cur.top().first] += time - prevTime ;
                cur.push({num, time});
                prevTime = time;
            }
        }
        return ans;
    }
};
