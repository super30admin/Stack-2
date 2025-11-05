// Time Complexity : O(n) where n is the number of tasks
// Space Complexity : O(n) for the stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using a stack to keep track of all open tasks and calculating the time it took based on the timestamp. When the task ends, pop it from the stack and update the result based on the timestamp of when the task was started.
 */

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<int[]> st = new Stack<>();

        for (String log : logs) {
            String[] split = log.split(":");
            int task = Integer.valueOf(split[0]);
            String action = split[1];
            int timestamp = Integer.valueOf(split[2]);

            // start action
            if (action.equals("start")) {
                // if there was any existing task running, pause it and add its time to result
                if (!st.isEmpty()) {
                    int[] lastRunning = st.peek();
                    res[lastRunning[0]] += timestamp - lastRunning[1];
                }

                st.push(new int[]{task, timestamp});
            }
            // end action
            else {
                int[] currRunning = st.pop();
                // doing +1 since "1:start:2","1:end:5" results in 4 instead of 3
                res[task] += timestamp - currRunning[1] + 1;
                // previous task resumes from 6 in commented example
                if (!st.isEmpty()) {
                    st.peek()[1] = timestamp + 1;
                }
            }
        }

        return res;
    }
}