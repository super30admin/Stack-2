// Time Complexity : 0(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> s = new Stack<>();
        int curr = 0;
        int prev = 0;
        int[] res = new int[n];
        for (String log : logs) {
            String[] str = log.split(":");
            curr = Integer.parseInt(str[2]);
            if (str[1].equals("start")) {
                if (!s.isEmpty()) {
                    res[s.peek()] += curr - prev;
                }
                s.push(Integer.parseInt(str[0]));
                prev = curr;
            } else {
                res[s.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }

        return res;
    }
}