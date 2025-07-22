/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time Complexity- O(N)
Space Complexity- O(N)
*/
import java.util.List;
import java.util.Stack;
public class ExclusiveTimeofFunctions_LC_636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int result[] = new int[n];
        int prev = 0, current = 0;
        for (String log : logs) {
            String[] splitLogs = log.split(":");
            int taskId = Integer.parseInt(splitLogs[0]);
            current = Integer.parseInt(splitLogs[2]);
            String function = splitLogs[1];
            //previous task has paused
            if (function.equals("start")) {
                if (!st.isEmpty()) {
                    result[st.peek()] += current - prev;
                }
                st.push(taskId);
                prev = current;
            } else {
                //resolve
                result[st.pop()] += current + 1 - prev;
                prev = current + 1;
            }
        }
        return result;
    }
}