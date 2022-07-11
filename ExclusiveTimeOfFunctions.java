//https://leetcode.com/problems/exclusive-time-of-functions/
// Time Complexity :O(n)  
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result=new int[n];
        Stack<Integer> st=new Stack<>();
        int prev=0,curr=0;
        for(String log:logs)
        {
            String[] s=log.split(":");
          
            if(s[1].equals("start"))
            {
                curr=Integer.parseInt(s[2]);
                if(!st.isEmpty())
                 result[st.peek()]+=curr-prev;
                st.push(Integer.parseInt(s[0]));
               
                prev=curr;
            }
            else{
               
                curr=Integer.parseInt(s[2]);
                if(!st.isEmpty())
                   result[st.pop()]+=curr-prev+1;
                prev=curr+1;
                
            }
           
        }
        return result;
    }
}