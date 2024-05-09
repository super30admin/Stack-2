// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/exclusive-time-of-functions/
// Any problem you faced while coding this : No


class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prev = 0;
        for(String log:logs){
            String[] splitArr = log.split(":");
            int curr = Integer.parseInt(splitArr[2]);
            int task = Integer.parseInt(splitArr[0]);
            if(splitArr[1].equals("start")){
                //pause the prev task in stack and record its time
                if(!st.isEmpty()){
                    result[st.peek()]+=curr-prev;
                }
                prev = curr;
                st.push(task);
            }else{
                // it will be end log.
                result[st.pop()]+=curr+1-prev;
                prev = curr+1;
            }
        }
        return result;
    }
}
