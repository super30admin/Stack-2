// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// We declare 2 variables prev and curr
// As we iterate through each log, if its a start log
// result[s.peek()] is incremented by curr - prev and prev is updated to curr
// Then push log id into stack
// If it is an end log
// result[s.pop()] is incremented by cur - prev + 1 and prev is updated to curr + 1

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        if(logs == null || logs.size() == 0) return new int[] {};
        
        int[] result = new int[n];
        
        Stack<Integer> s = new Stack<>();
        
        int prev = 0, curr = 0;
        
        for(String log: logs) {
            
            String[] splitString = log.split(":");
            curr = Integer.parseInt(splitString[2]);
            
            if(splitString[1].equals("start")) {
                if(!s.isEmpty()) {
                    result[s.peek()] += curr - prev;
                    prev = curr;
                }
                s.push(Integer.parseInt(splitString[0]));
            } 
            else 
            {
                result[s.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        return result;
    }
}