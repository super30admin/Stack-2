// Time Complexity : O(N) : N is total number of logs 
// Space Complexity : O(n) : n is total number of functions
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//split the input logs wrt ":"
//update priorTImestamp and currentTimestamp accordingly
//calculate result. Remember to update the result with previous everytime.
//use stack to store the function IDs

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] result = new int[n];
        
        Stack<Integer> s = new Stack<>();
        int priorTimestamp = 0, currentTimestamp = 0;
        
        
        for(String log: logs){
            String[] parsedData = log.split(":");
            
            int functionId = Integer.parseInt(parsedData[0]);
            String event = parsedData[1];
            currentTimestamp = Integer.parseInt(parsedData[2]);
            
            if(event.equals("start")){
                if(!s.isEmpty()){
                    result[s.peek()] += currentTimestamp - priorTimestamp;
                }
                s.push(functionId);
                priorTimestamp = currentTimestamp;
            }else{
                if(!s.isEmpty()){
                    result[s.peek()] += currentTimestamp - priorTimestamp + 1;
                }
                s.pop();
                priorTimestamp = currentTimestamp + 1;
            }
        }
        
        return result;
    }
}
