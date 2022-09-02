import java.util.List;
import java.util.Stack;

// Time Complexity : O(m+n), m=no. of logs, n=no.of processes
// Space Complexity : O(m/2) ~ O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (n == 0)
            return new int[] {};

        Stack<Integer> s = new Stack<>();
        int[] result = new int[n];
        int curr = 0, prev = 0;

        for (String log : logs) {
            String[] splitArray = log.split(":");
            curr = Integer.parseInt(splitArray[2]);
            if (splitArray[1].equals("start")) {
                if (!s.isEmpty()) {
                    result[s.peek()] += curr - prev;
                }
                int functionId = Integer.parseInt(splitArray[0]);
                s.push(functionId);
                prev = curr;
            } else {
                result[s.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }

        }
        return result;

    }
}