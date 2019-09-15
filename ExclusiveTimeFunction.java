//tc:o(n)
//sc :o(n)
//idea is to store function id in stack and it's corresponding time in result array.
//compute time by substracting current time from previous time.
//if function is "start" then time is curr - prev  and prev is set to curr. function start at begining of timestamp.
//if funtion is "end" then time is curr - prev +1 and prev is set to curr +1 because function is ending at the end of timestamp so other process cant start at same curr time.

//note we can not use hashmap because here function order of function is important and according to order time needs to be added.["0:start:0","1:start:2","1:end:5","0:end:6"]
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
	            }else{
	                result[stack.peek()]+= curr - prev +1;
	                stack.pop();
	                prev = curr+1;
	            }
	        }
	        return result;
	    }
}
	