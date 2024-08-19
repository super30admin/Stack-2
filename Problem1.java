/*
    LC - 636. Exclusive Time of Functions
    TC - O(length of logs)
    SC - O(length of logs which is stored in stack) ideally its O(length of logs / 2) but ignoring constant.
*/

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(n == 0) {
            return new int[] {};
        }
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        int curr = 0; // timestamp
        int[] result = new int[n];
        for(String log: logs) {
            String[] strs = log.split(":");
            curr = Integer.parseInt(strs[2]);
            if(strs[1].equals("start")) {
                if(!st.isEmpty()) {
                    result[st.peek()] += curr - prev;
                }
                st.push(Integer.parseInt(strs[0]));
                prev = curr;
            } else {
                result[st.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }

        return result;
    }
}