import java.util.List;
import java.util.Stack;

/*
## Problem 1: Exclusive Time of Functions (https://leetcode.com/problems/exclusive-time-of-functions/)

Time Complexity :   O (n) 
Space Complexity :  O (n)
Did this code successfully run on Leetcode :    Yes (636. Exclusive Time of Functions)
Any problem you faced while coding this :       No
 */
// Input: n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
// Output: [3,4]

class ExclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        int prev = 0;
        
        Stack<Integer> st = new Stack<>();
        
        for(String log: logs){
            String[] strArray = log.split(":");  // [1:start:2]
            int task = Integer.parseInt(strArray[0]);
            int curr = Integer.parseInt(strArray[2]);
            
            // start
            if(strArray[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev; 
                }
                prev = curr;
                st.push(task);
            }
            else{
                result[st.pop()] += curr+1 - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}