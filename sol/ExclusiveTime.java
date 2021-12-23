package sol;

import java.util.*;

public class ExclusiveTime {

	// Time complexity :O(n)
//		Space: O(n)
	
	  public int[] exclusiveTime(int n, List<String> logs) {
	        
	      int [] ans= new int[n];
	        
	       Stack<Integer> st= new Stack<>();
	        int prev=0; 
	        for(String s :logs){
	            
	            String [] log= s.split(":");
	           
	            int cur=Integer.parseInt(log[2]);
	            String op=log[1];
	            int fun=Integer.parseInt(log[0]);
	            
	           // System.out.println(st+" "+cur+" "+prev);
	            
	            
	            if(op.equals("start")){
	                
	                if(!st.isEmpty()){
	                    
	                   ans[st.peek()]+=cur-prev;
	                    prev=cur;
	                    
	                }
	                
	                st.push(fun);
	                
	                
	                
	            }else{
	                
	                ans[st.peek()]=ans[st.peek()]+cur-prev+1;
	                st.pop();
	                prev=cur+1;
	            }
	            
	            
	        }
	        
	        return ans;
	        
	        
	        
	    }
	
}
