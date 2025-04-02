// https://leetcode.com/problems/exclusive-time-of-functions/

// Time Complexity: O(n) where n is the number of logs
// Space Complexity: O(n)


class Log{
    public: 
        int id;
        bool isStart;
        int time;
    
        Log(string &temp){
            size_t idx1 = temp.find(":");
            size_t idx2 = temp.find(":", idx1+1);
    
            id = stoi(temp.substr(0,idx1));
            isStart = temp.substr(idx1+1, idx2-idx1-1) == "start";
            time = stoi(temp.substr(idx2+1));
        }
    };
    class Solution {
    public:
        vector<int> exclusiveTime(int n, vector<string>& logs) {
            vector<int> ans(n,0);
            stack<Log> st;
            for(auto temp:logs){
                Log log(temp);
                if(log.isStart){
                    st.push(log);
                }
                else{
                    Log top = st.top();
                    st.pop();
                    ans[top.id] += log.time - top.time + 1;
                    if(!st.empty()){
                        ans[st.top().id] -= log.time - top.time + 1;
                    }
                }
            }
            return ans;
    
        }
    };