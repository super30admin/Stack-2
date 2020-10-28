// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Using stack
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        
        int currTime = 0;
        int prev = 0;
        
        for(String log : logs){
            String[] record = log.split(":");
            
            currTime = Integer.parseInt(record[2]);
            
            if(record[1].equals("start")){
                if(!stack.isEmpty()){
                    res[stack.peek()] += currTime - prev;
                }
                
                stack.push(Integer.parseInt(record[0]));
                prev = currTime;
            }else{
                res[stack.pop()]+=currTime - prev + 1;
                prev=currTime + 1;
            }
        }
        return res;  
    }
}
