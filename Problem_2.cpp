// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Exclusive time of functions
// Approach: Stack
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public:
        vector<int> exclusiveTime(int n, vector<string>& logs) {
            vector<int> result(n, 0);
            stack<int> st;
            int prevTime = 0;
            
            for (const string& log : logs) {
                stringstream ss(log);
                string token;
                vector<string> parts;
                while (getline(ss, token, ':')) {
                    parts.push_back(token);
                }
                
                int id = stoi(parts[0]);
                string type = parts[1];
                int time = stoi(parts[2]);
                
                if (type == "start") {
                    if (!st.empty()) {
                        result[st.top()] += time - prevTime;
                    }
                    st.push(id);
                    prevTime = time;
                } else { // "end"
                    result[st.top()] += time - prevTime + 1;
                    st.pop();
                    prevTime = time + 1;
                }
            }
            return result;
        }
    };
    