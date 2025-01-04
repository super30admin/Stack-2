// Approach : Using Stack we can keep track of the previous task that was running and
// need to be paused before the start of another task.
// Time : O(t)
// Space : O(n) // stack space almost n/2
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[n];

        int prev = 0;
        for (String log : logs) {
            String[] process = log.split(":");
            int id = Integer.parseInt(process[0]);
            String processType = process[1];
            int curr = Integer.parseInt(process[2]);
            if (processType.equals("start")) {
                if (!stk.isEmpty()) {
                    // already some log started in the stack
                    // need to be paused
                    result[stk.peek()] += curr - prev;
                }
                // First log started
                stk.push(id);// add process id to the stack
            } else {
                curr = curr + 1;
                // process ended so remove from stack;
                result[stk.pop()] += curr - prev ; // end the process and save time in result
            }
            prev = curr; // curr time of process
        }

        return result;
    }
}