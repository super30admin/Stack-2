//Exclusive Time of Functions
// Time Complexity : O(m) - logs size
// Space Complexity :O(m) - stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach
//use stack to store id, also have a prev variable to record the prev time. 
import java.util.*;
public class Problem1 {
    public static void main(String[] args){
        Problem1 p = new Problem1();
        List<String> ls  = new ArrayList<>();
        ls.add("0:start:0");
        ls.add("1:start:2");
        ls.add("1:end:5");
        ls.add("0:end:6");
        int[] res = p.exclusiveTime(2, ls);
        for(int i : res){
            System.out.print(i+" ");
        }

    }
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        int prev = 0;
        for(int i = 0;i< logs.size(); i++){
            String[] eachString = logs.get(i).split(":");
            int id = Integer.parseInt(eachString[0]);
            int curr = Integer.parseInt(eachString[2]);
            if(eachString[1].equals("start")){
                if(!st.isEmpty()){
                    
                    res[st.peek()] += curr - prev;
                    prev = curr;
                    
                }
                st.push(id);
                
            }
            else{
                res[st.pop()] += curr -prev +1;
                prev = curr +1;
            }
            
        }
        return res;
        
    }
    
}

