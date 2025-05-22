// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Approach:
// Use a stack to track the currently running function by its ID.
// For each log entry, calculate how much time has passed since the previous log and assign it to the function on top of the stack.
// On a start log, push the new function to the stack, on an end log, pop the function and update its time.

import java.util.*;
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st=new Stack<>();
        int[] result=new int[n];
        int prev=0;
        for(String log:logs){
            String[] splitArr=log.split(":");
            int processId=Integer.parseInt(splitArr[0]);
            String processType=splitArr[1];
            int curr=Integer.parseInt(splitArr[2]);
            if(processType.equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()]+=curr-prev;
                }
                st.push(processId);
            }else{
                curr=curr+1;
                result[st.pop()]+=curr-prev;
            }
            prev=curr;
        }
        return result;

    }
}