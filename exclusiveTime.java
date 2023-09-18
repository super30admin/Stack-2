// Time Complexity : O(max(m,n)), m - number of logs, n - number of tasks
// Space Complexity : O(n) - n is the number of tasks
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
 * 1. Iterate over the logs and split the string by ":" to get the task, start/end and the time.
 * 2. If the start is encountered, check if the stack is empty. If not, add the difference of the current time and the previous time to the result.
 * 3. Push the task to the stack and update the previous time.
 * 4. If the end is encountered, pop the task from the stack and add the difference of the current time and the previous time + 1 to the result.
 * 5. Update the previous time to the current time + 1.
 * 6. Return the result.
 */

import java.util.List;
import java.util.Stack;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prev = 0;

        for(String log : logs){
            String[] splitLog = log.split(":");
            int curr = Integer.parseInt(splitLog[2]);
            int task = Integer.parseInt(splitLog[0]);
            if(splitLog[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }
                st.push(task);
                prev = curr;
            }else {
                int prevTask = st.pop();
                result[prevTask] += curr + 1 - prev;
                prev = curr + 1;
            }
        }

        return result;
    }
}