// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
//Use stack to store the different taskIds
//When the log type is start, push that task to stack and pause the ongoing task and compute its time taken so far
//when the log type is end, pop the task from stack and compute its time taken which will be curTime + 1

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int prevTime = 0;
        Stack<Integer> st = new Stack<>();
        for(String log: logs) {
            String[] strArr = log.split(":");
            int taskId =Integer.parseInt(strArr[0]);
            int curTime = Integer.parseInt(strArr[2]);
            String type = strArr[1];

            if(type.equals("start")) {
                if(!st.isEmpty()) {
                    res[st.peek()] += curTime - prevTime; //cur pauses and calc time covered so far
                }
                prevTime = curTime;
                st.push(taskId);
                
            } else {
                //end
                res[st.pop()] += curTime + 1 - prevTime;
                prevTime = curTime+1;
            }
        }
        return res;
    }
}
