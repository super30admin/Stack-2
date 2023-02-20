// Approach: Use a stack to store the taskIds. As every new task starts, prev running task is paused
// which means, we need to store the time elapsed for that task in result[] array.
// If a task ends, pop that task's Id from the stack and add its time in result as curr + 1 - prev.
// Time: O(n)
// Space: O(n)

import java.util.*;

class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null) return new int[0];
        int result[] = new int[n];
        int prev = 0;
        Stack<Integer> st = new Stack();

        for (String log : logs) {
            String splitLog[] = log.split(":");
            int taskId = Integer.parseInt(splitLog[0]);
            int curr = Integer.parseInt(splitLog[2]);

            if (splitLog[1].equals("start")) {
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