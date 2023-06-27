// Time Complexity : O(m) where m = log.size();
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we use a stack to store the previous function IDs.
// Important thing to observe is start time is beginning and end time is at the end of given time.so we properly update curr,prev accordingly.
// we maintain two variables curr and prev to store the timestamps and calculate the answer .

class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        vector<int>res(n,0);
        int m = logs.size();
        stack<int>st;
        int prev = 0,curr = 0;
        for(int i = 0;i<m;i++){
            string s = logs[i];
            vector<string>word;
            int pos = 0;
            while((pos=s.find(":"))!=string::npos){
                string p = s.substr(0,pos);
                word.push_back(p);
                s.erase(0,pos+1);
            }
            if(!s.empty()){
                word.push_back(s);
            }
            curr = stoi(word[2]);
            if(word[1] == "start"){
                if(!st.empty()){
                    res[st.top()]+= curr - prev;
                }
                prev = curr;
                st.push(stoi(word[0]));
            }
            else{
                res[st.top()]+= curr-prev+1;
                st.pop();
                prev = curr+1;
            }
            
        }
        return res;
    }
};

