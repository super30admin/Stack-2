// Time complexity: O(n)
// Space complexity: O(n)

// Approach: we are using a stack. We keep adding new tasks to the stack when we see the "start" string in the log. But when we add the new task, we need to calculate how long the previous task one was running for. We can find the previous task by peeking the top most element from stack. Now when we see the "end" string, which means the task is ending, we need to pop from the stack but before that calculate how long the task ran for. We need to add 1 when calculating duration for the ending task

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
       Stack<Integer> stack = new Stack<>();
       int[] result = new int[n];
       int prevTimeStamp = 0;
       for (String log : logs) {
           String[] split = log.split(":");
           int id = Integer.parseInt(split[0]);
           String action = split[1];
           int currTimestamp = Integer.parseInt(split[2]);
           
           if (action.equals("start")) {
               // when starting a new task, we need to push the id of the new task to the stack. But before that we need to calculate the time that the old task was running for
               if (!stack.isEmpty()) {
                  result[stack.peek()] += currTimestamp - prevTimeStamp; 
               }
               prevTimeStamp = currTimestamp;
               stack.push(id);
           }
           else {
               // when ending a task, we need to pop it from the stack. But before that we need to calculate how long the task ran for
               result[stack.peek()] += currTimestamp + 1 - prevTimeStamp;
               prevTimeStamp = currTimestamp + 1;
               stack.pop();
           }
       }
       return result;
    }
}