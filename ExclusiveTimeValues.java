// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are iterating through the list linearly   
//Space Complexity: O(n) since we are using an extra stack for our operations
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        if(logs == null || logs.size() == 0) return res;
        
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        for(String log : logs){
            String[] strs = log.split(":");
            int curr = Integer.parseInt(strs[2]);
            if(strs[1].equals("start")){
                if(!st.isEmpty()){
                    res[st.peek()] += curr - prev;
                    prev = curr;
                }
                st.push(Integer.parseInt(strs[0]));
            }else{
                res[st.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        
        return res;
    }
}