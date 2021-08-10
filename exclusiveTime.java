// Time Complexity :O(log.length)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st= new Stack<>();
        int[] count=new int[n];
        int prev=0;
        int curr=0;
        
        for(String s : logs){
            String[] str= s.split(":");
            curr=Integer.parseInt(str[2]);
            if(st.isEmpty()){
                st.push(Integer.parseInt(str[0]));
            }
           else if(str[1].equals("start")){//for starting the process
               count[st.peek()]+=curr-prev;
               st.push(Integer.parseInt(str[0]));
               prev=curr;
           }
            else{//for end of the process
                count[st.pop()]+=curr-prev+1;
                prev=curr+1;
            }
        }
        return count;
    }
}