// Time Complexity -> O(n)
// Space Complexity -> O(n) for the stack.
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
    private:
    vector<string> splitLog(string s){
        vector<string> result;
        int l = s.size();
        string curr = "";
        for(int i = 0; i < l; i++){
            if(s[i] != ':')
                curr += s[i];
            if(s[i] == ':' || i == l-1){
                if(curr != ":")
                    result.push_back(curr);
                curr = "";
            }
        }
        return result;
    }
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        vector<int> answer(n);
        stack<int> st;
        int prev = 0;
        for(string log : logs){
            vector<string> currLog = splitLog(log);
            int id = stoi(currLog[0]);
            int timeSt = stoi(currLog[2]);
            if(currLog[1] == "start"){
                if(!st.empty()){
                    int prevId = st.top();
                    answer[prevId] +=  timeSt - prev;
                    
                }
                st.push(id);
                prev = timeSt;
            }else{
                int prevId = st.top(); st.pop();
                answer[prevId] += timeSt + 1 - prev;
                prev = timeSt+1;
            }
        }
        return answer;
    }
};