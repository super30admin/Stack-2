// Tc: O(nl) = O(n)
// Sc: O(n/2) = O(n)

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if (n == 0 || logs == null || logs.size() == 0) {
            return result;
        }

        Deque<Integer> stack = new ArrayDeque<>();

        int prevTime = 0;

        for (String log : logs) {
            String[] logParts = log.split(":");
            int curTime = Integer.parseInt(logParts[2]);

            if ("start".equals(logParts[1])) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += curTime - prevTime;
                }
                stack.push(Integer.parseInt(logParts[0]));
                prevTime = curTime;
            } else {
                result[stack.pop()] += curTime - prevTime + 1;
                prevTime = curTime + 1;
            }
        }

        return result;
    }
}