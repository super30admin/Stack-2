// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 
// Leetcode : 636
//Approach: Stack

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs.size()== 0 || logs == null) return new int[0];
        
        int [] res = new int[n];
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        for(String str : logs){
            String[] splitMsg = str.split(":");
            int curr = Integer.parseInt(splitMsg[2]);
            if(splitMsg[1].equals("start")){
                if(!st.isEmpty()){
                    res[st.peek()]+= curr - prev;
                    prev = curr;
                }
                st.push(Integer.parseInt(splitMsg[0]));
            }
            else{
                res[st.pop()]+=curr-prev+1;
                prev = curr+1;
            }
           
        }
        
       return res; 
    }
}