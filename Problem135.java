//TC: O(m)
//SC: O(n)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];  // Array to store the exclusive time for each function
        Stack<Integer> stack = new Stack<>();  // Stack to track the currently executing function
        int prevTime = 0;  // Tracks the previous timestamp
        
        for (String log : logs) {
            // Split the log into components: function_id, action, and timestamp
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String action = parts[1];
            int timestamp = Integer.parseInt(parts[2]);
            
            if (action.equals("start")) {
                if (!stack.isEmpty()) {
                    // Add the time difference to the function on top of the stack
                    result[stack.peek()] += timestamp - prevTime;
                }
                // Push the new function onto the stack
                stack.push(id);
                prevTime = timestamp;  // Update the previous time to the current timestamp
            } else {
                // Add the time spent by the current function
                result[stack.pop()] += timestamp - prevTime + 1;
                prevTime = timestamp + 1;  // Update prevTime to the next time after this function ends
            }
        }
        
        return result;
    }
}
