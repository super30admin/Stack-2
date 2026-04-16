// Time Complexity : O(m), m = length of the logs
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We iterate the input list of logs and we split each log to fetch the corresponding process id, process type
and current time required for that task. Now, if the process is of start type, we use a stack and initially
we push it when its empty, but later, aling with pushing it, we make sure to pause the previous running task
by fetching it from the peek of the stack and adding the difference of current and previous times to it. If
the process is ending, it means we need to pop the stack and update the run time for that process id, by again
computing the difference of runtimes.However, we need to increment the currenttime as it fully takes that entire
block.Lastly, we need to update the previous with the current process for each iteration.
 */
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int prevTime = 0;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        for(String log : logs) {
            String[] splitLog = log.split(":");
            int processId = Integer.parseInt(splitLog[0]);
            String processType = splitLog[1];
            int currTime = Integer.parseInt(splitLog[2]);

            if("start".equals(processType)) {
                if(!st.isEmpty()) {
                    result[st.peek()] += currTime - prevTime;
                }
                st.push(processId);
            }
            else {
                currTime = currTime + 1;
                result[st.pop()] += currTime - prevTime;
            }
            prevTime = currTime;
        }
        return result;
    }
}