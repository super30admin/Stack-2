//TC:o(n)
//SC:o(n)

import java.util.List;
import java.util.Stack;
public class ExclusiveTimeFunction {
	    public int[] exclusiveTime(int n, List<String> logs) {
	        int prev = 0;
	        int curr = 0;
	        Stack<Integer> stack = new Stack<>();
	        int[] result = new int[n];
	        for(String log:logs){
	            String[] record =log.split(":");
	            curr = Integer.parseInt(record[2]);
	            if(record[1].equals("start")){
	                if(!stack.isEmpty()){
	                    result[stack.peek()]+= curr - prev;
	                }
	            stack.push(Integer.parseInt(record[0]));
	            prev = curr;
	            }
                else{
	                result[stack.peek()]+= curr - prev +1;
	                stack.pop();
	                prev = curr+1;
	            }
	        }
	        return result;
	    }
}

