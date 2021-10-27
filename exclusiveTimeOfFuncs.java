// Time Complexity : O( max(m,n) )
// Space Complexity : O( max(m,n) )
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        // null
        if(logs == null || logs.size() == 0) return new int[n];
        int[] result = new int [n];
        int prev = 0;
        Stack<Integer> st = new Stack<>();
        
        for(String log: logs){
            String[] splitArr = log.split(":");
            int curr = Integer.parseInt(splitArr[2]); // current time
            if(splitArr[1].equals("start")){
                if(!st.isEmpty()){ // look at prev task
                    result[st.peek()] += curr - prev;
                }
                prev = curr;
                st.push(Integer.parseInt(splitArr[0]));
            } else{ //end process
                result[st.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}