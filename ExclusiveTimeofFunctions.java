// Time Complexity : O(N) - N - no of logs
// Space Complexity : O(N) N - no of logs, if there are no end logs just the function start logs.
// Did this code successfully run on Leetcode : Yes;(https://leetcode.com/submissions/detail/679804931/)
// Any problem you faced while coding this : No;
// My Notes : Add the START function calls to the stack.
// Before adding update the prev function time with the current start time. When function end encounter, pop and cal difference time.
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int prevTime = 0;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(String log : logs){
            String[] funcParts = log.split(":");
            int funcId = Integer.parseInt(funcParts[0]);
            int funcTime = Integer.parseInt(funcParts[2]);
            if(funcParts[1].equals("start")){
                if(!stack.isEmpty()){
                    // Add previous function its execution time
                    result[stack.peek()]+=funcTime - prevTime;
                }
                // push the curr function and store the time
                stack.push(funcId);
                prevTime = funcTime;
            }else{
                // end
                // pop and add the calc the execution time
                result[stack.pop()]+=funcTime - prevTime + 1;
                prevTime = funcTime+1;
            }
           
        }
        return result;
    }
}