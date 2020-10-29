    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/exclusive-time-of-functions/
    Time Complexity for operators : o(n) .. size of logs
    Extra Space Complexity for operators : o(n) .. stack size
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 

        # Optimized approach: 
                              
            Approach   
                    A. 

       */
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs.size() == 0)
            return new int[0];
        
        int currTime = 0;
        int prev = 0;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(String log : logs){
            String[] str = log.split(":");
            currTime = Integer.parseInt(str[2]);
            if(str[1].equals("start")){
                if(!stack.isEmpty()){
                    result[stack.peek()] += currTime - prev; 
                }
                
                stack.push(Integer.parseInt(str[0]));
                prev = currTime;
            }else{
                result[stack.pop()] += currTime -  prev + 1;
                prev = currTime + 1;
            }
        }
        
        return result;
    }
}