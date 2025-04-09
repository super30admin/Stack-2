import java.util.List;
import java.util.Stack;

/**
 * Time Complexity: O(m), where m is the logs size
 * Space Complexity: O(m) where m is the logs size
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * - The stack helps us keep track of which function is currently active
 *  and which ones are waiting, so using stack
 * - Handle "start" logs:
 * If there's already a function running (stack is not empty),
 *  calculate the time it has been running till now and add it to its exclusive time.
 * Push the new function ID onto the stack (starts running).
 * Update prev to the current timestamp.
 * Handle "end" logs:
 * Pop the function from the stack (it's done running).
 * Calculate its time spent as curr - prev + 1 and add it to its exclusive time.
 * Update prev to curr + 1 (the next unit of time after the end).
 */

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int curr, prev;
        prev = 0;
        for (String log: logs) {
            String[] s = log.split(":");
            curr = Integer.parseInt(s[2]);
            String op = s[1];
            if (op.equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += curr - prev;
                } 
                stack.push(Integer.parseInt(s[0]));
                prev = curr;
            } else {
                result[stack.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        // Your code here
    }
}