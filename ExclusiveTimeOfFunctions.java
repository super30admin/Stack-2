// Time Complexity : O(N), N: no of logs + no of process
// Space Complexity : O(N) //stack, ignoring the output array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class ExclusiveTimeOfFunctions {
    class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            if(logs == null) return new int[0];
            int[] result = new int[n];
            Stack<Integer> st = new Stack<>();
            int prev = 0;
            int curr = 0;
            for(String log : logs) {
                String[] strArr = log.split(":");
                curr = Integer.parseInt(strArr[2]);
                if(strArr[1].equals("start")) {
                    if(!st.isEmpty()) {
                        result[st.peek()] += curr - prev;
                    }
                    st.push(Integer.parseInt(strArr[0]));
                    prev = curr;
                } else {
                    result[st.pop()] += curr + 1 - prev;
                    prev = curr+1;
                }
            }
            return result;
        }
    }
}
