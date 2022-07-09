// Time Complexity : O(No of logs)
// Space Complexity : O(No of unique funcs)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int prev = 0;
        int curr = 0;
        Stack<Integer> st = new Stack<>();
        for(String log: logs) {
            String[] strArr = log.split(":");
            curr = Integer.parseInt(strArr[2]);
            // at every start of a func,
            // we should pause the currently executing func
            // calculate its start substracting with last time stamp
            if(strArr[1].equals("start")) {
                if(!st.isEmpty()) {
                    res[st.peek()] += curr-prev;
                }
                st.push(Integer.parseInt(strArr[0]));
                prev = curr;
            } else {
                // at everyy end, we neeed to stop the currently executing func
                res[st.pop()] += curr-prev+1;
                prev = curr+1;
            }
        }
        return res;

    }
}