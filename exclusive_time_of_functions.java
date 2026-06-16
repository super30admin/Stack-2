// Time Complexity : O(m) where m is the number of logs
// Space Complexity : O(n) for the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use a stack to keep track of the currently running function because function calls are nested.
// Before processing a new log, we assign the elapsed time since the previous timestamp to the function at the top of the stack.
// For an end log, we add the inclusive execution time, pop the function, and move prev to the next time unit.

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        int[] result = new int[n];

        for(String log : logs) {
            String[] splitArr = log.split(":");
            int processId = Integer.parseInt(splitArr[0]);
            String processType = splitArr[1];
            int curr = Integer.parseInt(splitArr[2]);

            // pause current running function
            if(processType.equals("start")) {
                if(!st.isEmpty()) {
                    result[st.peek()] += curr - prev;
                }
                st.push(processId);
            } else {

                // end time is inclusive
                curr += 1;
                result[st.pop()] += curr - prev;
            }

            prev = curr;
        }

        return result;
    }
}