// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs==null){
            return null;
        }
        
        int[] result = new int[n];
        int curr = 0;
        int prev = 0;
        Stack<Integer> st = new Stack<>();
        for(String log: logs){
            String[] arr = log.split(":");
            curr = Integer.parseInt(arr[2]);
            if(arr[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }
                prev=curr;
                st.push(Integer.parseInt(arr[0]));
            }else{
                result[st.pop()]+=curr+1-prev;
                prev = curr+1;
            }
        }
        return result;
    }
}