// Time Complexity : O(logs)
// Space Complexity : O(logs/2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prevTime=0;
        for(String log : logs){
            String[] process = log.split(":");
            int currTask = Integer.parseInt(process[0]);
            int currTime = Integer.parseInt(process[2]);

            if(process[1].equals("start")) {
                //pause the prev process
                if(!st.isEmpty()) {
                    result[st.peek()] += currTime - prevTime;
                }

                st.push(currTask);
                prevTime = currTime;
            }else{
                currTime = currTime+1;
                result[st.pop()] += currTime - prevTime;
                prevTime = currTime;
            }
        }
        return result;
    }
}