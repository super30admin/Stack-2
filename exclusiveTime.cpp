// Time Complexity : O(n) where n is the number of inputs in logs
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


/* 
The idea is to push the processes into the stack and everytime we do that, update the time of the previous process in the result array
At end, update the time again and pop from stack
Mantian prev and curr to calculate the time of each process
For pop, i.e. end, the curr = curr + 1 since the process completes at end of t
*/

class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        if(logs.size() == 0) return vector<int>();
        stack<int> processes;
        int prev = 0;
        vector<int> result (n, 0);

        for(auto log: logs){
            string action;
            int functionId, curr;
            // split the input by :
            processInput(log, functionId, action, curr); 

            // if its start, update the time spent for the previous process in the stack
            // push the newprocess intp the satck 
            // update the prev to the end of curr process
            if(action.compare("start") == 0) {
                if(!processes.empty())
                    result[processes.top()] += curr - prev;
                processes.push(functionId);
                prev = curr;
            }

            // if its end, update the time taken
            // the curr = curr + 1 because the process ends at the end of time t and not the beginning 
            // update the prev and pop the element 
            else {
                result[processes.top()] += curr + 1 - prev;
                processes.pop();
                prev = curr + 1; 
            }
        }
        return result;
    }

private:
    void processInput(string& log, int& functionId, string& action, int& curr){
        stringstream ss(log);
        string s;
        getline(ss, s, ':');
        functionId = stoi(s);
        getline(ss, s, ':');
        action = s;
        getline(ss, s);
        curr = stoi(s);
    }
};