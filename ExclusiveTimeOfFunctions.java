// Time Complexity : O(m) m = size of logs
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
// Stack approach -> Add to stack on start, pop on end.
// Maintain a prev counter to keep a track of the last elements time
// On Start -> Update the result of the top element in the stack (currTime - Prev) and push the new value to stack
// On end -> Update the result of the top element in the stack and pop it.

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        int[] result = new int[n];
        Stack<Integer> stack = new Stack();
        int prev = 0;

        for(int i = 0; i < logs.size(); i++) {
            String[] log = logs.get(i).split(":");
            int taskId = Integer.parseInt(log[0]);
            String operation = log[1];
            int time =  Integer.parseInt(log[2]);

            if(operation.equals("start")) {
                if(!stack.isEmpty()) {
                    int prevTask = stack.peek();
                    result[prevTask] += time - prev;
                }
                prev = time;
                stack.push(taskId);
            } else {
                if(!stack.isEmpty()) {
                    int prevTask = stack.pop();
                    result[prevTask] += time - prev + 1;
                    prev = time + 1;
                }
            }

        }
        return result;


    }
}
