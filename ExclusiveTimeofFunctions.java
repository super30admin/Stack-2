// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
// If we look at logs it looks like a paranthesis - Stack problem
        // we will store the jobId in stack - so we can track when it starts and ends
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prev = 0;

        for (String log : logs) {

            String[] logElements = log.split(":");  // "0:start:0"
            int jobId = Integer.parseInt(logElements[0]);
            String mode = logElements[1];
            int curr = Integer.parseInt(logElements[2]);

            if (mode.equals("start")) {
                // just get the time consumed, add in result
                if (!st.isEmpty()) {
                    result[st.peek()] += curr - prev;
                }
                st.add(jobId);
                prev = curr;
            }  else {
                // mode is end -> Increment curr by 1 as end consumes whole unit
                curr = curr + 1;
                result[st.pop()] += curr - prev;
                prev = curr;
            }
        }
        return result;
    }
}