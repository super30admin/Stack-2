636. Exclusive Time of Functions

TC - O(n)
SC - O(n)

class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        if (logs.size() == 0) return {0};
        vector<int> result(n, 0); 
        stack<int> st;
        int prev = 0;
        for(string log: logs) {
            stringstream ss(log);
            string temp, temp2, temp3;
            getline(ss, temp, ':');
            getline(ss, temp2, ':');
            getline(ss, temp3, ':');

            //Log item = {stoi(temp), temp2, stoi(temp3)};
            int cur = stoi(temp3);
            int curTaskid = stoi(temp);
            if (temp2  == "start") {
                if(st.size()!=0) {
                    result[st.top()]+=cur - prev;
                }
                prev = cur;
                st.push(curTaskid);
            } else {
                result[st.top()]+= cur+1-prev;
                st.pop();
                prev = cur+1;
            }
        }
        return result;
    }
};



