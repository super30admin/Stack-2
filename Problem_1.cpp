/**
 * @Time Complexity:
 * O(N) where N is the number of log lines
 * 
 */

/**
 * @Space Complexity:
 * O(N) where N is the number of log lines
 * 
 */

/**
 * @Approach:
 * Think thsi problem like a valid parenthesis problem. If a process starts after
 * another process, then we store the first process in the stack and the second
 * process becomes our priority to solve first. So we look for latter's
 * end point first. Then we go for the first process.
 * 
 * We maintain two variables to keep the record of time. First the
 * first process id is pushed to the stack. Then we look for the second
 * log. Depending on the start or end time we change the values in our 
 * result. If we encounter start, we take the difference of the current and
 * previous time and store it in the resultant vector for the process whose
 * id is at the top of the stack. We also push the id of the current log
 * to the stack.
 * 
 * If we encounter end we again take the difference but we also add 1 to the difference
 * because the process runs till the end of the time unit. for example :
 *                    |3|4|5|
 *                    <----->
 * The process runs till the end of 4, so our answer sholud be 5-3 +1.
 * Then we update the previous with current +1 and pop the top id
 * as it has been taken care of.
 */

// The code ran perfectly on leetcode

class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        vector<int> result(n);
        if(logs.empty() || logs.size() == 0) return {};
        stack<int> st;
        int prev = 0;
        int pos = 0;
        for(auto l : logs){
            vector<string> split;
            string id;
            string state;
            string time;
            stringstream s(l);
            getline(s, id, ':');
            getline(s, state, ':');
            getline(s, time, ':');
            int curr = stoi(time);
            
            if(state == "start"){
                if(!st.empty()){
                    result[st.top()] += curr - prev;
                    prev = curr;
                }
                st.push(stoi(id));
            } else {
                result[st.top()] += curr + 1 - prev;
                st.pop();
                prev = curr + 1;
                
            }
            
        }
        
        return result;
    }
};