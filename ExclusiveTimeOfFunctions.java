//Problem 134: Exclusive Time of Functions
//TC:O(logs size)
//SC:O(number of starts in logs or half the length of the logs)


/*
Steps: Using stack, just add the id, whenever there status is start and pop when status is end
User 'prev' counter to keep track of the last element time
When status is Start -> Update the result of the top element in the stack (currTime - prev) and push the incoming/new id to the stack
When status is end   -> Update the result of the top element in the stack to currTime-prev+1 by popping it.Here +1 because for the time slice of 1 unit and then update prev = currTime+1;

*/

import java.util.*;
class Solution134 {
    public int[] exclusiveTime(int n, List<String> logs) {
        //TC:O(logs size) | SC:O(number of starts in logs or half the length of the logs)
        int res[]=new int[n];
        
        if(logs==null || logs.size()==0) return res;
        
        Stack<Integer> stack = new Stack<>();
        
        int prev =0;
        
        for(String str:logs){
            String[] arr = str.split(":");
            int id = Integer.parseInt(arr[0]);
            String status = arr[1];
            int currTime = Integer.parseInt(arr[2]);
            if(status.equals("start")){
                
                if(!stack.isEmpty()){
                    res[stack.peek()] += currTime - prev;
                    prev = currTime;
                }   
                
                stack.push(id);
                
            }else{//if status is end
                res[stack.pop()] += currTime-prev+1;
                prev = currTime+1;
            }
            
        } 
        
        return res;
    }
    
}