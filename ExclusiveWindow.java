// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create stack to maintan the sequence of function IDs.
// Very first function will be added to stack directly and set the timestamp to prev_time
// If next start happens, difference of prev_time and current function start time will be mapped to result[functionId] --> Function id is peeked from stack
// If any function ends, result[functionID] will be added with the prev_time - curr_time.


class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if(n == 0)
            return result;
        
        Stack<Integer> stack = new Stack<>();
        int prev_time = 0 , curr_time = 0;
        for(String log : logs){
            // logs is in 0:start:0 -->FunctionID:Start or Stop:TimeitstartedOrEnded
            String[] token = log.split(":");
            int functionID = Integer.parseInt(token[0]);
            curr_time = Integer.parseInt(token[2]);
            
            if(token[1].equals("start")){
                if(!stack.isEmpty())
                    result[stack.peek()] += curr_time - prev_time;
                
                stack.push(functionID);
                prev_time= curr_time;
                
            }else{
                result[functionID] += curr_time - prev_time + 1;
                 stack.pop();
                prev_time= curr_time + 1;
               
            }
            
        }
        return result;
    }
}
