// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//636. Exclusive Time of Functions
//https://leetcode.com/problems/exclusive-time-of-functions/


class Solution {
    //time: O(n)
    //space: O(n)
    public int[] exclusiveTime(int n, List<String> logs) {
       
        int len = logs.size();
        
        String[] s;
        int[] result = new int[n];
        int prev = 0;
        int curr;
        int id =0;
        boolean flag = false;
        Stack<Integer> st = new Stack<>();
        
        for(String str: logs){
            
            //skip first log
            s = new String[3];
            s = str.split(":"); 
            
            if(st.isEmpty()){
                st.push(Integer.valueOf(s[0]));
            
            //logic
            //if s[1] == start then curr = s[2], time interval = curr-prev, prev = s[2], result[s[0]]=time interval
            }else if(s[1].equals("start")){
                curr = Integer.valueOf(s[2]);               
                result[st.peek()] += curr-prev;                    
                prev = Integer.valueOf(s[2]);               
                st.push(Integer.valueOf(s[0]));                
                 
                
            //else if s[1] == end then curr = s[2], time interval = curr+1-prev, prev = s[2]+1, result[s[0]]=time interval    
            }else if(s[1].equals("end")){
                curr = Integer.valueOf(s[2]);      
                result[st.peek()] += curr+1-prev;         
                prev = Integer.valueOf(s[2])+1;    
                st.pop();        
                  
            }
             
        }
        
        return result;
    }
}
