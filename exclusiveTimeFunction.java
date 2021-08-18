// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        for(String log : logs){
            String[] temp = log.split(":");
            int id = Integer.parseInt(temp[0]);
            String tag = temp[1];
            int curr = Integer.parseInt(temp[2]);
            if(tag.equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                    prev = curr;
                }
                st.push(id);
            }else{
                result[st.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        return result;
    }
}
