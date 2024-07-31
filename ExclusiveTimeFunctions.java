// Time Complexity : O(length of logs)
// Space Complexity : O(length of logs)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Initialize Result and Stack: Create an array result to store exclusive execution times and use a stack s to track currently running function IDs.
//Iterate and Process Logs: For each log, parse the function ID, action (start/end), and timestamp. If a function starts, record the elapsed time since the last action for the function on top of the stack and push the new function ID onto the stack.
//Update Times: When a function ends, calculate its exclusive time by adding the duration to result and adjust the prev timestamp for the next log.

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(n == 0){
            return new int[]{};
        }

        int curr = 0, prev =0;
        Stack<Integer> s = new Stack<>();
        int[] result = new int[n];
        for(String log : logs){
            String[] strArray = log.split(":");
            curr = Integer.parseInt(strArray[2]);
            if(strArray[1].equals("start")){
                if(!s.isEmpty()){
                    result[s.peek()] += curr - prev;
                }
                s.push(Integer.parseInt(strArray[0]));
                prev = curr;
            }
            else{
                result[s.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }

        return result;
    }
}
