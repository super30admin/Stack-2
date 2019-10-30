/**
 * On a single threaded CPU, we execute some functions. Each function has a
 * unique id between 0 and N-1.
 * 
 * We store logs in timestamp order that describe when a function is entered or
 * exited.
 * 
 * Each log is a string with this format: "{function_id}:{"start" |
 * "end"}:{timestamp}". For example, "0:start:3" means the function with id 0
 * started at the beginning of timestamp 3. "1:end:2" means the function with id
 * 1 ended at the end of timestamp 2.
 * 
 * A function's exclusive time is the number of units of time spent in this
 * function. Note that this does not include any recursive calls to child
 * functions.
 * 
 * The CPU is single threaded which means that only one function is being
 * executed at a given time unit.
 * 
 * Return the exclusive time of each function, sorted by their function id.
 * 
 * 
 * Idea: Use a stack
 * Space Complexity: O(n)
 * Time Complexity: O(size(logs))
 */
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        int prev = 0, curr = 0;
        for (String log : logs) {
            String[] tokens = log.split(":");
            curr = Integer.parseInt(tokens[2]);
            if (tokens[1].equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += curr - prev;
                }
                stack.push(Integer.parseInt(tokens[0]));
                prev = curr;
            } else {
                result[stack.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }

        return result;
    }
}