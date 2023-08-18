// Time Complexity : O(n)
// Space Complexity : O(n/2)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if (n == 0 || logs == null || logs.size() == 0) {
            return result;
        }

        // This stack will store the function ids
        Deque<Integer> stack = new ArrayDeque<>();
        // Previous time = start/resume time of the previous function
        int prevTime = 0;

        for (String log : logs) {
            String[] logParts = log.split(":");
            int curTime = Integer.parseInt(logParts[2]);

            if ("start".equals(logParts[1])) {
                // Function is starting now
                if (!stack.isEmpty()) {
                    // Add the exclusive time of previous function
                    result[stack.peek()] += curTime - prevTime;
                }
                stack.push(Integer.parseInt(logParts[0]));
                // Setting the start time for next log.
                prevTime = curTime;
            } else {
                // Function is ending now.
                // Make sure to +1 to as end takes the whole unit of time.
                result[stack.pop()] += curTime - prevTime + 1;
                // prevTime = resume time of the function. Thus adding 1.
                prevTime = curTime + 1;
            }
        }

        return result;
    }
}