// Time Complexity : O(#logs)
// Space Complexity : O(#logs) in worst case
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// when function starts and ends, runtime is t2-t1+1
// when 2nd function gets called at t2, temp run time of t1 is t2-t1
// we iterate over logs and keep track of runtime for functions ids

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int prev = 0;
        int cur = 0;
        
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        
        for(String log : logs){
            String[] record = log.split(":");
            cur = Integer.parseInt(record[2]);
            
            if(record[1].equals("start")){
                
                if(!stack.isEmpty()){
                    result[stack.peek()] += cur - prev; 
                }
                
                stack.push(Integer.parseInt(record[0]));
                prev = cur;
            }
            else{
                result[stack.peek()] += cur-prev+1;
                stack.pop();
                 prev = cur+1;
            }
        }
        
        return result;
    }
}