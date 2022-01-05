// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        
        int prev = 0;
        int curr = 0;
        
        for (String log : logs) {
            String[] strings = log.split(":");
            
            curr = Integer.parseInt(strings[2]);
            
            if (strings[1].equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += curr - prev;
                }
                stack.push(Integer.parseInt(strings[0]));
                prev = curr;
            }
            
            else { //end
                result[stack.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
            
        }
        return result;
    }
}