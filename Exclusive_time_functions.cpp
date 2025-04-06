// Time Complexity: O(n)
// Space Complexity: O(n)
// Does this code run on Leetcode: Yes

// Approach:
// 1. Create a stack to store the function ids
// 2. Traverse the logs and check if the log is a start or end log
// 3. If it is a start log, push the function id into the stack and update the previous timestamp
// 4. If it is an end log, pop the function id from the stack and update the result array with the exclusive time
// 5. Return the result array

class Solution {
    public:
        vector<int> exclusiveTime(int n, vector<string>& logs) {
            vector<int> result(n, 0);
            stack<int> stack;
            int prev = 0;
            
            for(const string& log : logs){
                int pos1 = log.find(':');
                int pos2 = log.rfind(':');
                int id = stoi(log.substr(0, pos1));
                string type = log.substr(pos1 + 1, pos2 - pos1 - 1);
                int timestamp = stoi(log.substr(pos2 + 1));
    
                if(type == "start"){
                    if(!stack.empty()){
                        result[stack.top()] += timestamp - prev;
                    }
                    stack.push(id);
                    prev = timestamp;
                }else{
                    result[stack.top()] += timestamp - prev + 1;
                    stack.pop();
                    prev = timestamp + 1;
                }
            }
            return result;
        }
    };