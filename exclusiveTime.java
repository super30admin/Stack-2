// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int prev = 0;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (String log : logs) {
            String[] l = log.split(":");
            int currId = Integer.parseInt(l[0]);
            int curr = Integer.parseInt(l[2]);

            if (l[1].equals("start")) {
                if (!stk.isEmpty())
                    res[stk.peek()] += curr - prev;

                prev = curr;
                stk.push(currId);

            } else {
                res[stk.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }

        }

        return res;
    }
}