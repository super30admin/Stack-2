// Time Complexity :O(N) where N is no of logs
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// We use a stack to keep track of currently executing functions along with their start times.
// When a new function starts, we pause the previous one and accumulate its execution time.
// When a function ends, we finalize its time and resume the parent function accordingly.

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[n];

        for (int i = 0; i < logs.size(); i++) {
            String[] log = logs.get(i).split(":");
            int id = Integer.parseInt(log[0]);
            String type = log[1];
            int time = Integer.parseInt(log[2]);

            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    int[] top = stack.peek();
                    result[top[0]] += time - top[1];
                }
                stack.push(new int[]{id, time});
            } else { // "end"
                int[] top = stack.pop();
                result[top[0]] += time - top[1] + 1;

                if (!stack.isEmpty()) {
                    stack.peek()[1] = time + 1;
                }
            }
        }
        return result;
    }
}
