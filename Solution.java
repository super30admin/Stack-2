// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Add the curr-prev calculation to existing result value at that index


// Your code here along with comments explaining your approach
class Solution {
    Stack<Integer> st;
    public int[] exclusiveTime(int n, List<String> logs) {
        int prev = 0;
        st = new Stack<>();
        int[] result = new int[n];
        for(String log: logs){
            String[] splitLog = log.split(":");
            int currTask = Integer.parseInt(splitLog[0]);
            int curr = Integer.parseInt(splitLog[2]);
            if(splitLog[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr-prev;
                }
                prev = curr;
                st.push(currTask);
            }
            else{
                result[st.pop()]+= curr-prev+1;
                prev = curr+1;
            }

        }
        return result;
    }
}