import java.util.Stack;

//Time Complexity : O(n) where n = size of logs list
//Space Complexity : O(n) where n = size of logs list
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//636. Exclusive Time of Functions (Medium) - https://leetcode.com/problems/exclusive-time-of-functions/
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null) return new int[0];
        int[] result = new int[n];
        int prev = 0;
        
        // Storing function ID's in stack
        Stack<Integer> stack = new Stack<>(); // O(n)
        
        for (String log : logs) { // O(n)
            String[] strArr = log.split(":");
            int functionID = Integer.parseInt(strArr[0]);
            int currTime = Integer.parseInt(strArr[2]);
            
            if (strArr[1].equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += currTime - prev;
                }
                
                prev = currTime;
                stack.push(functionID);
            } else {
                result[stack.pop()] += currTime + 1 - prev;
                prev = currTime + 1;
            }
        }
        
        return result;
    }
}