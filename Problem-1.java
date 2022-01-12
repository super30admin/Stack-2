// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        int curr = 0;
        int prev = 0;
        
        for(String string : logs) {
            
            String[] s = string.split(":");
            curr = Integer.parseInt(s[2]);
            
            if(s[1].equals("start")) {
                
                if(!stack.isEmpty()) {
                    result[stack.peek()] += curr-prev;
                }
                
                prev = curr;
                stack.push(Integer.parseInt(s[0]));
                
            } else {
                
                result[stack.pop()] += curr - prev + 1;
                prev = curr+1;
            }
        }
        
        return result;
    }
}