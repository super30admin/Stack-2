import java.util.List;
import java.util.Stack;

/**
 * Approach: Use stack to store ids,
 * prev pointer to track end time of previous task
 * and curr pointer to track end time of current task.
 * Main functionsTime array as resultant and
 * keep adding time taken for each function before pausing or ending it.
 */
// TC: O(N)
// SC: N/2 for stack ~= O(N)
class Solution {
    private static final String COLON = ":";
    private static final String START = "start";
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] functionsTime = new int[n];
        Stack<Integer> idStack = new Stack<>();
        int prev = 0;
        for (String log: logs) {
            String[] logArray = log.split(COLON); // ["1", "start", "2"]
            int curr = Integer.parseInt(logArray[2]); // 2
            int taskId = Integer.parseInt(logArray[0]); // 1
            if (START.equals(logArray[1])) {
                // pause the previous task and record its time
                if (!idStack.isEmpty()) {
                    // add execution time before pausing the task
                    functionsTime[idStack.peek()] += curr - prev;
                }
                prev = curr; // update end time
                idStack.push(taskId);
            } else {
                // end the task
                // add execution time before ending the task
                functionsTime[idStack.pop()] += (curr + 1) - prev;
                prev = curr + 1; // update end time
            }
        }
        return functionsTime;
    }
}