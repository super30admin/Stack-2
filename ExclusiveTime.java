// Time Complexity : O(logs)
// Space Complexity : O(logs/2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int[] ExclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prevTime = 0;
        for(String log : logs) {
            String[] statement = log.split(":");
            int currProcess = Integer.parseInt(statement[0]);
            int currTime = Integer.parseInt(statement[2]);
            if(statement[1].equals("start")) {
                if(!st.isEmpty()) {
                    result[st.peek()] += currTime-prevTime;
                }
                st.push(currProcess);
            } else {
                currTime = currTime+1;
                result[st.pop()] += currTime-prevTime;
            }
            prevTime = currTime;
        }
        return result;
    }
}