// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        int prev = 0;
        int curr = 0;

        for (String entry : logs) {
            String[] logSplit = entry.split(":");

            int funcId = Integer.parseInt(logSplit[0]);
            curr = Integer.parseInt(logSplit[2]);

            if (logSplit[1].equals("start")) {
                if (!st.isEmpty()) {
                    result[st.peek()] += curr - prev;
                }
                st.push(funcId);
                prev = curr;
            } else {
                result[funcId] += curr - prev + 1;
                st.pop();
                prev = curr + 1;

            }
        }

        return result;
    }
}