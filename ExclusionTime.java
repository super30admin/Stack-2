/**
 * Time Complexity : O(n) where n is the string length
 * Space Complexity : O(n)
 */
import java.util.*;

public class ExclusionTime{
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if(logs == null || logs.size() == 0){return new int[0];}                                   
        Stack<Integer> stk = new Stack<>();
        int prev = 0;
        for(String s: logs){
            String[] temp = s.split(":");                                     
            int id = Integer.parseInt(temp[0]);                                                    
            int curr = Integer.parseInt(temp[2]);                                                  
            if(temp[1].equals("start")){
                if(!stk.isEmpty()) result[stk.peek()] += curr - prev;                              
                prev = curr;
                stk.push(id);                                                               
            } else
            if(temp[1].equals("end")){                                                             
                stk.pop();                                                                         
                result[id] += curr - prev + 1;                                                     
                prev = curr + 1;                                                        
            }
            }        
        return result;
       }
}