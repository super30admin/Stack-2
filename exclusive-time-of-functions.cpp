// Time Complexity: O(logs.size()) 
// Space Complexity: O(n) n = #functions

class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        stack<int> st;
        vector<int> res(n, 0);
        int prevTime = 0;
        for(auto log : logs) {
            stringstream ss(log);
            string temp;
            int fID, timeStamp;
            string startEnd;
            getline(ss, temp, ':');
            fID = stoi(temp);
            getline(ss, temp, ':');
            startEnd = temp;
            getline(ss, temp, ':');
            timeStamp = stoi(temp);
            if(startEnd == "start") {
                if(!st.empty()) {
                    res[st.top()] += timeStamp - prevTime;
                    prevTime = timeStamp;
                }
                st.push(fID);
            }
            else {
                res[st.top()] += timeStamp - prevTime + 1;
                st.pop();
                prevTime = timeStamp + 1;
            }
        }
        return res;
    }
};
