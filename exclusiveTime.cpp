// Time Complexity : O(n) just got thru string
// Space Complexity : O(n) stack
// Did this code succesfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Maintain a stack of indices, a prev variable indicating start of unaccounted time so far and go thru input strings
// 2. If the string is a start, then the job at top of stack will be halted. Account for time it has ran so far with curr start - prev
// 3. If the string is an end,  then the job at top of stack will be ended.  Account for time it has ran by curr+1-prev and update prev to curr+1 
// 4. prev is updated to curr+1 since from that onwards again the time is unresolved

class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        vector<int> result(n,0);
        if(logs.size()==0)
            return result;
        int timeLapsed = 0;
        int prev=0;
        stack<int> st;
        for(auto log: logs){
            cout<<log<<endl;
            vector<string> tokens;
            string token;
            istringstream iss(log);
            while (getline(iss, token,':'))
            {
                tokens.push_back(token);
            }
            if(tokens[1] == "start"){
                if(!st.empty()){
                    int idx=st.top();
                    result[idx] += stoi(tokens[2])-prev;
                    prev = stoi(tokens[2]);
                }
                st.push(stoi(tokens[0]));
                cout<<"size: "<<st.size()<<endl;
            }
            else{
                int idx = st.top(); st.pop();
                cout<<"idx: "<<idx<<endl;
                int totalTime = stoi(tokens[2]) + 1 - prev;
                result[idx] += totalTime;
                prev = stoi(tokens[2]) + 1;
            }
        }
        return result;
    }
};