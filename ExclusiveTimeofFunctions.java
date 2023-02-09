// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;
class Solution {

    //If the log is a start log, we just push it to the stack.
    //If it is an end log, that means that a function call just ended, 
    //and the last log in the stack is the log for the same function in the "start" state

    public int[] exclusiveTime(int n, List<String> logs) {
        
        Stack<Log> st = new Stack<>();
        int[] result = new int[n];

        for (String l1 : logs){
            Log log = new Log(l1);
            if (log.isStart){
                st.push(log);
            } else {
                Log top = st.pop();
                result[top.id] += log.time - top.time + 1; 
                if (!st.isEmpty()){
                    result[st.peek().id] -= log.time - top.time + 1; 
                }
            }
        }
        return result;
    }

    class Log{
        int id;
        boolean isStart;
        int time;

        public Log(String log){
            String[] str = log.split(":");
            this.id = Integer.parseInt(str[0]);
            this.time = Integer.parseInt(str[2]);
            this.isStart = str[1].equals("start");
        } 
    }
}