// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// TC : O(n)
// SC : O(n)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
       if(n==0)
       {
        return new int[]{};
       } 
       int cur=0;
       int prev=0;
       int res[]=new int[n];
       Stack<Integer> s=new Stack<>();
       for(String log:logs)
       {
        String logString[]=log.split(":");
         cur=Integer.parseInt(logString[2]);
        if(logString[1].equals("start"))
        {
            if(!s.isEmpty())
            {
                res[s.peek()] += cur-prev;
               
                
            }
            s.push(Integer.parseInt(logString[0]));
            prev=cur;
           
            
        }
        else{
            res[s.pop()]+=cur-prev+1;
            prev=cur+1;
        }
       }
       return res;
    }
}
// Problem 2
// TC : O(n)
// SC : O(n)
class Solution {
    public boolean isValid(String s) {
       if(s.length()==1) return false;
       Stack<Character> st=new Stack<>();
       for(int i=0;i<s.length();i++)
       {
           char c=s.charAt(i);
           if(c=='('||c=='{'||c=='[')
           {
               st.push(c);
           }
           else{
               if(st.empty()) return false;
               char ret=st.peek();
               st.pop();
               if((c!=')'&&ret=='(')||(c!=']'&&ret=='[')||c!='}'&&ret=='{')
               {
                   return false;
               }
             
           }
       }
       return st.empty();
    }
}