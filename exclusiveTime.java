// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//use thr stack to store the incomplete process and 
//perform the calculation according to the start or end operation
//retreive from the stack incompleted operations, when they occur again in the future

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        int ind, prev = 0, curr;
        for (String log : logs) {
            String[] stArray = log.split(":");
            curr = Integer.parseInt(stArray[2]);
            if (stArray[1].equals("start")) {
                ind = Integer.parseInt(stArray[0]);
                if (!st.isEmpty()) {
                    ans[st.peek()] += curr - prev;
                }
                st.push(ind);
                prev = curr;
            } else {
                ans[st.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        return ans;
    }
}