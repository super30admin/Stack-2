/* Problem Statement:

VERIFIED ON LEETCODE PLATFORM 
636. Exclusive Time of Functions
Medium

On a single threaded CPU, we execute some functions.  Each function has a unique id between 0 and N-1.

We store logs in timestamp order that describe when a function is entered or exited.

Each log is a string with this format: "{function_id}:{"start" | "end"}:{timestamp}".  For example, "0:start:3" means the function with id 0 started at the beginning of timestamp 3.  "1:end:2" means the function with id 1 ended at the end of timestamp 2.

A function's exclusive time is the number of units of time spent in this function.  Note that this does not include any recursive calls to child functions.

The CPU is single threaded which means that only one function is being executed at a given time unit.

Return the exclusive time of each function, sorted by their function id.

 

Example 1:

Input:
n = 2
logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
Output: [3, 4]
Explanation:
Function 0 starts at the beginning of time 0, then it executes 2 units of time and reaches the end of time 1.
Now function 1 starts at the beginning of time 2, executes 4 units of time and ends at time 5.
Function 0 is running again at the beginning of time 6, and also ends at the end of time 6, thus executing for 1 unit of time. 
So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.

 
Note:

    1 <= n <= 100
    Two functions won't start or end at the same time.
    Functions will always log when they exit.

 * Solution 1: using Stack
   Time Complexity : O(n) 
 * Space complexity :O(n) as stack space should also be taken into consideration 
 */

class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        int log_size = logs.size(); /* size of the logs input  */
        int prev_marker; /* Points to the last point where the curr_time was updated */
        string str_mark; /* Will be used for tokenization */
        
        int unique_id, point; /* input str --> unique_id : marker : point */
        string marker;
        vector<int> result(n, 0); /* initialize result */
        int idx;
        stack<int> stck; /* will use stack to store the information about window */
        
        if (log_size == 0 || n == 0) {
            return result;
        }
        
        /* Initialize ss class object with string input */
        std::istringstream ss(logs[0]);
        std::getline(ss, str_mark, ':');
        unique_id = stoi(str_mark);
        std::getline(ss, marker, ':');
        std::getline(ss, str_mark, ':');
        point = stoi(str_mark);
        
        /* push first element and set the prev marker as start point */
        stck.push(unique_id);
        prev_marker = point;
        
        for (idx = 1; idx < log_size; idx++) {
            
            /* parse */
            std::istringstream ss(logs[idx]);
            std::getline(ss, str_mark, ':');
            unique_id = stoi(str_mark);
            std::getline(ss, marker, ':');
            std::getline(ss, str_mark, ':');
            point = stoi(str_mark);
             
            /* If I get a start point, then do the following */
            if (marker.compare("start") == 0) {
                /* if stack is not empty, then update the total unique time elapse for that
                 function using the prev_marker */
                if (!stck.empty()) {
                    result[stck.top()] += point - prev_marker;                 
                }
                /* Putting a new function in stack, so update the prev marker */
                prev_marker = point;
                stck.push(unique_id);
            }else {
                /* Got an end, time to pop from stack. but before popping it please 
                 update the result array time for that particular element */
                result[stck.top()] += point - prev_marker + 1;
                /* update the previous marker. here we do point + 1 as the function has
                 completely finished execution, so set the prev_marker to the next time*/
                prev_marker = point + 1;
                stck.pop();
            }
            
        }
        return result;
    }
};/* Execute on leetcode platform */


