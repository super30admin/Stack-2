// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
      
      Stack<Integer> stack = new Stack<>();
      
      int prev = 0;
      int curr =0;
      
      int[] output = new int[n];
      
      for(String log:logs)
      {
        String[] split = log.split(":");
        
        curr= Integer.parseInt(split[2]);
        
        if(split[1].equals("start"))
        {
          if(!stack.isEmpty())
          {
             output[stack.peek()] += curr - prev;
              prev = curr;
          }
          stack.push(Integer.parseInt(split[0]));
        }
        else
        {
          output[stack.pop()] += curr - prev +1;
          prev = curr +1;
        }
      }
        return output;
    }
}