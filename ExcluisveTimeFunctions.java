// Time Complexity : O(N)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.List;
import java.util.Stack;

public class ExcluisveTimeFunctions {
	 public int[] exclusiveTime(int n, List<String> logs) {
	        Stack<Integer> stack=new Stack<>();
	        int[] result=new int[n];
	        int prev=0;
	        int curr=0;
	        for(int i=0;i<logs.size();i++){
	            String s=logs.get(i);
	            String[] log=s.split(":");
	            curr=Integer.parseInt(log[2]);
	           
	            if(log[1].equals("start")){
	                  if(!stack.isEmpty()){
	                      result[stack.peek()]+=curr-prev;
	                  }
	                stack.push(Integer.parseInt(log[0]));
	                   prev=curr;
	            }else{
	                int top=stack.pop();
	                result[top]+=curr+1-prev;
	                prev=curr+1;
	            }
	            
	        }
	        
	        return result;
	        
	    }
}
