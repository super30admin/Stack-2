// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int prev = 0; int curr = 0;
        for(String log: logs) {
            String[] strArr = log.split(":");
            curr = Integer.parseInt(strArr[2]);
            if(strArr[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }
                st.push(Integer.parseInt(strArr[0]));
                prev=curr;
            } else {
                result[st.pop()] += curr+1-prev;
                prev = curr+1;
            }
        }
        return result;
    }
}