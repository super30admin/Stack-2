// Time Complexity : O(n) where n is the length of logs
// Space Complexity : O(n) where n is the length of logs divided by 2
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class exclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        for (String log : logs) {
            String[] arr = log.split(":");
            int curr = Integer.parseInt(arr[2]);
            // start
            if (arr[1].equals("start")) {
                if (!st.isEmpty()) {
                    ans[st.peek()] += curr - prev;
                }
                st.push(Integer.parseInt(arr[0]));
                prev = curr;
            } else { // end
                ans[st.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        return ans;
    }
}