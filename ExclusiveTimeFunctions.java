// In this problem, Iterate through each logs and using a stack, whenever a function starts executing, maintaining it's start time 
// in curr varaible and pushing it's id into the stack, so the top of the stack indicates the current function that is executing. 
// Now, move to next log, so set the prior to the current id first, and now new current id is current's log's id. If the current 
// log is also a start, that means previously the function that was executing, calculate its time (curr-prev) and store it in 
// result array at that index. And push the current log's id to the stack, and update prev now to curr's id, and move. Suppose,
// if the current log was not a start, but it was end, than pop from the stack and at that index in result array store curr-prev+1
// and update prev to curr+1. 

// Time Complexity : O(n) where n is the length of logs list
// Space Complexity : O(n) stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        // Base case
        if (n == 0 || logs == null || logs.size() == 0) {
            return new int[] {};
        }
        // Declare result array of size n
        int[] result = new int[n];
        // Prev and curr variables for storing timestamps
        int prev = 0;
        int curr = 0;
        // Stack for pushing the function's id when next function starts executing
        Stack<Integer> s1 = new Stack<>();
        // Loop through all the logs
        for (int i = 0; i < logs.size(); i++) {
            // Since each log is a string, split it into strings array
            String[] s = logs.get(i).split(":");
            // Store the curr timestamp in curr
            curr = Integer.parseInt(s[2]);
            // Check if this new log is a start of any function
            if (s[1].equals("start")) {
                // If yes than check if stack is not empty, means there was function which was
                // executing
                if (!s1.isEmpty()) {
                    // Go that index of that function and add the time for which it executed until
                    // now, that is curr-prev
                    result[s1.peek()] += curr - prev;
                }
                // Than push the curr function's id
                s1.push(Integer.parseInt(s[0]));
                // Change prev to curr
                prev = curr;
            } else {
                // Else if the current log is a end of function, do s.pop and in result array at
                // that index add curr-prev+1
                result[s1.pop()] += curr - prev + 1;
                // Change prev to curr+1
                prev = curr + 1;
            }
        }
        // Return result array
        return result;
    }
}