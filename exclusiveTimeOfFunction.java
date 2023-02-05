// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * store the taskid in stack. and check the status of the log,
 * if it is start add the value to existing in the stack and add the result , 
 * if it is end then pop from the stack.
 */
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null)
            return new int[0];

        int[] result = new int[n];
        int prev = 0;
        Stack<Integer> st = new Stack<>();
        for (String log : logs) {
            String[] splitlog = log.split(":");
            int taskId = Integer.parseInt(splitlog[0]);
            int curr = Integer.parseInt(splitlog[2]);
            if (splitlog[1].equals("start")) {
                if (!st.isEmpty()) {
                    result[st.peek()] += curr - prev;
                }
                st.push(taskId);
                prev = curr;
            } else {
                result[st.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }

        return result;
    }
}