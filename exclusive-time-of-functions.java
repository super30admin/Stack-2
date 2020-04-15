// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        
        int prevTimestamp=0, currTimestamp=0;
        
        for(String log : logs)
        {
            String[] tokens=log.split(":");
            
            int func_id=Integer.parseInt(tokens[0]);
            currTimestamp=Integer.parseInt(tokens[2]);
            
            if(tokens[1].equals("start")) {
                if(!stack.isEmpty())
                    result[stack.peek()] += currTimestamp - prevTimestamp;
                stack.push(func_id);
                prevTimestamp=currTimestamp;
            } else {
                result[func_id] += currTimestamp-prevTimestamp+1;
                stack.pop();
                prevTimestamp=currTimestamp+1;
            }
        }
        return result;
    }
}
