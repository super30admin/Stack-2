// Time Complexity : O(M)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We use stack to solve this problem
// we check for the command, if start we put the result as curr-prev and push the index on to the stack
// when it is end we pop and add the time

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null && logs.size() == 0)
            return new int[] {};

        int[] result = new int[n];
        Stack<Integer> s = new Stack();
        int prev = 0;
        for (String log : logs) {
            String[] str = log.split(":");
            int curr = Integer.parseInt(str[2]);

            if (str[1].equals("start")) {
                if (!s.isEmpty()) {
                    result[s.peek()] += curr - prev;
                }
                prev = curr;
                s.push(Integer.parseInt(str[0]));
            } else {
                result[s.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}