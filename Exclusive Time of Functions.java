/*
Time Complexity
O(logs.length) → Each log is processed exactly once, and each function id is pushed and popped once from the stack.
Space Complexity (SC)
O(n) → The stack can store up to n function ids in the worst case (if all functions are nested).

Approach 
Initialize:

An int[] result to store exclusive times for each function.
A stack to keep track of currently running (active) function ids.
A prev variable to track the previous timestamp processed.
Iterate through each log:
Parse the id, action (start/end), and timestamp.

If start:
If a function is already running (!stack.isEmpty()), add curr - prev to its exclusive time since the last timestamp.
Push the new id on the stack (it becomes the active function).
Update prev = curr.

If end:
Pop the current function id from the stack (it finishes).
Add curr - prev + 1 to its time (because end is inclusive).
Update prev = curr + 1 to mark the start of the next time unit.
Return the result array after all logs are processed.

*/

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int curr = 0, prev = 0;
        for (String log : logs) {
            String[] splits = log.split(":");
            int id = Integer.parseInt(splits[0]);
            curr = Integer.parseInt(splits[2]);
            if (splits[1].equals("start")) {
                if (!st.isEmpty()) {
                    result[st.peek()] += curr - prev;
                }
                st.push(id);
                prev = curr;
            } else {
                result[st.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        return result;
    }
}
