// Time Complexity : O(n)
// Space Complexity : O(n/2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1: We use a stack to maintain the taskIds that are currently in progress and have not ended
// 2: For start actions, we pause the previous task by updating the result array and move our pointers accordingly. Then we insert the new taskId
// 3: For end actions, we update the result array using the taskId at the top of the stack and then increment the pointers
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prev = 0;

        for (String log : logs) {
            String[] splitArr = log.split(":");
            int taskId = Integer.parseInt(splitArr[0]);
            String action = splitArr[1];
            int time = Integer.parseInt(splitArr[2]);
            int curr = time;
            System.out.println("action:" + action);
            if (action.equals("start")) {
                // pause the previous task
                if (!st.isEmpty()) {
                    result[st.peek()] += curr - prev;
                }
                // record the time
                prev = curr;
                st.push(taskId);

            } else {
                result[st.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}