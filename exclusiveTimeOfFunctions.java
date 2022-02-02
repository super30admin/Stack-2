// Time Complexity :O(l), where l is no. of logs
// Space Complexity :O(n), where n is no. of functions
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// we use a stack to hold the ongoing functions (till they end)
// in case of 'start' we don't pop the element from the stack, whereas in 'end' case we pop it
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();
        int prev = 0;

        for (String log: logs) {
            String[] logArray = log.split(":");
            int curr = Integer.valueOf(logArray[2]);
            int idx = Integer.valueOf(logArray[0]);

            if(logArray[1].equals("start")) {
                if (!s.isEmpty()) {
                    result[s.peek()] += (curr - prev);
                }
                prev = curr;
                s.push(idx);
            }
            else {
                result[s.pop()] += (curr+1 - prev);
                prev = curr+1;
            }
        }

        return result;
    }
}