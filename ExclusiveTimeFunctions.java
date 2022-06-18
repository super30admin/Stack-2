// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        int prev = 0, curr = 0;
        
        for(String log: logs) {
            String[] split = log.split(":");
            int processId = Integer.parseInt(split[0]);
            String event = split[1];
            int time = Integer.parseInt(split[2]);
            
            curr = time;

            if("start".equals(event)) {
               
                if(!stack.isEmpty()) {
                    result[stack.peek()] += curr - prev;
                }
                
                prev = curr;
                stack.push(processId);
            } else {
                
                result[stack.pop()] += (curr + 1) - prev;
                prev = curr + 1;
            }

        }
        
        return result;
    }
}