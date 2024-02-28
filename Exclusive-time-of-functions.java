// Time Complexity : O(length(logs))

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using stack, if its start push the task id in the stack and subtract
// curr - prev. If end pop from stack and minus by adding curr+1.

// 636. Exclusive Time of Functions

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int [] res = new int[n];
        int prev = 0;
        Arrays.fill(res,0);
        Stack<Integer> st = new Stack<>();
        for(String log : logs){
            String [] splitLog = log.split(":");
            int taskId = Integer.parseInt(splitLog[0]);
            int curr = Integer.parseInt(splitLog[2]);
            if(splitLog[1].equals("start")){
                if(!st.isEmpty()){
                    res[st.peek()] += curr - prev;
                }
                st.push(taskId);
                prev = curr;
            }
            else{
                res[st.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return res;
    }
}