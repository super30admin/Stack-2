// Time Complexity : O(n)
// Space Complexity : O(n)
// n is the length of given input logs
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        // null check
        if(logs == null)
            return new int[0];
        int prev = 0;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        for(String log : logs){
            String[] strArr = log.split(":");
            int task = Integer.parseInt(strArr[0]);
            int curr = Integer.parseInt(strArr[2]);

            //start log
            if(strArr[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }
                prev = curr;
                st.push(task);
            }
            //end log
            else{
                result[st.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}
