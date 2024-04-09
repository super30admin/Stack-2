// TC: O(n)
// SC: O(n)

// Approach: Keep track of time, whenever you encounter a new task,
// calculate time for the prev task. Pop it if it ends

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int prevTime = 0;
        int[] res = new int[n];
        // stores function ids
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < logs.size(); i++) {
            String[] logArr = logs.get(i).split(":");

            int funcId = Integer.parseInt(logArr[0]);
            int newTime = Integer.parseInt(logArr[2]);
            String eventType = logArr[1];

            if (stack.isEmpty()) {
                prevTime = newTime;
                stack.push(funcId);
                continue;
            }

            // some task ran for a bit
            if (eventType.equals("start")) {
                res[stack.peek()] += newTime - prevTime;
                prevTime = newTime;
                stack.push(funcId);
            } else {
                res[stack.pop()] += newTime - prevTime + 1;
                prevTime = newTime + 1;
            }
        }

        return res;
    }
}
