class Solution {
    //TC : O(N)
    //SC : O(N)
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        int prev = 0;
        vector<int> result(n, 0);
        stack<int> st;
        
        for (string& log : logs) {
            istringstream iss(log);
            string token;
            vector<string> splitLog;
            
            while (getline(iss, token, ':')) {
                splitLog.push_back(token);
            }
            
            int taskId = stoi(splitLog[0]);
            int curr = stoi(splitLog[2]);
            
            if (splitLog[1] == "start") {
                if (!st.empty()) {
                    result[st.top()] += curr - prev;
                }
                st.push(taskId);
                prev = curr;
            } else {
                result[st.top()] += curr + 1 - prev;
                st.pop();
                prev = curr + 1;
            }
        }
        
        return result;
    }
};