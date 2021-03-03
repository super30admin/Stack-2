import java.util.*;

public class ExclusiveTimeOfFunction {
	
	//TC - o(n)
    //SC - o(n)
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int [] result = new int [n];
        if(logs.isEmpty())
            return result;
        //resolve last log first 
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        
        for(String log:logs) {
            //split the logs 
            String [] s = log.split(":");
            //curr value will be the timestamp for that particular function
            int curr = Integer.parseInt(s[2]);
            if(s[1].equals("start")){
                //if it is not the first task calculate the cpu utilazation 
                //time for the last one and add it to result
                if(!st.isEmpty()) {
                    result[st.peek()] += curr -prev;
                    prev = curr;
                }
                //push current function to stack
                st.push(Integer.parseInt(s[0]));
            } 
            //end process
            else{
                //pop the last function from the stack and add units usage to existing result
                //start -3 end at -3 cae
                //so curr-prev+1
                result[st.pop()] +=curr+1-prev;
                //move curr to next block - 4th edge
                prev = curr+1;
            }
        }
        return result;
    }

}
