// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Approach
We use stack to calculate total time taken for each task
we take a result array of size(n) to store the 
we start itterating over logs
extracting "taskId" and "cur time"
if we encounter "start" we  check if  stack is empty if not we add the time passed 
to the total time for the task at the top of stack by doing cur -prev time
then using the current tastid to stack and make "prev time" equal to "cur time"

else
we pop from stack and add to cur+1-prev to the total time, we do +1 to because completion
we consume 1 unit of time
and add change prev to cur+1 for same reason
*/

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int cur = 0;
        int prev = 0;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for (String log : logs) {
            String[] str = log.split(":");
            int taskId = Integer.parseInt(str[0]);
            cur = Integer.parseInt(str[2]);
            if (str[1].equals("start")) {
                if (!st.isEmpty()) {
                    result[st.peek()] += cur - prev;
                }
                st.push(taskId);
                prev = cur;
            } else {
                int popped = st.pop();
                result[popped] += cur + 1 - prev;
                prev = cur + 1;
            }

        }
        return result;
    }
}