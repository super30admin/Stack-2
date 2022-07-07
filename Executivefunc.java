TC:O(n) n- LENGTH OF LOGS LIST
SC:O(n) 
Successfully run on leetcodes

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result=new int[n];
        Stack<Integer> st=new Stack<>();
        int prev=0,curr=0;
        for(String log:logs)
        {
            String[] s=log.split(":");
            curr=Integer.parseInt(s[2]);
            if(s[1].equals("start"))
            {
                
                if(!st.isEmpty())
                 result[st.peek()]+=curr-prev;
                st.push(Integer.parseInt(s[0]));
                prev=curr;
            }
            else{
               
                
                if(!st.isEmpty())
                   result[st.pop()]+=curr-prev+1;
                prev=curr+1;
                
            }
           
        }
        return result;
    }
}