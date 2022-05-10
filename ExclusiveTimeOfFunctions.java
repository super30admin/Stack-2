import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//Time Complexity : O(n)
//Space Complexity : O(n)
public class ExclusiveTimeOfFunctions {	
	/**Approach1: Stack**/
	public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> st= new Stack<>();//To store function id
        int prev=0; //previous timestamp
        int curr=0; //current timestamp       
        for(String log : logs){
            String[] strArr = log.split(":");
            curr= Integer.parseInt(strArr[2]); 
            if(strArr[1].equals("start")){ //push in stack
                if(!st.isEmpty()){
                    res[st.peek()] += curr - prev;
                }                    
                st.push(Integer.parseInt(strArr[0]));
                prev = curr;
            }else{ //pop from stack
                res[st.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return res;
    }
	
	// Driver code to test above
	public static void main (String[] args) {	
		ExclusiveTimeOfFunctions ob  = new ExclusiveTimeOfFunctions();		
		int n= 2; //1;
		List<String> logs = Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6"); 
		//Arrays.asList("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7");
		System.out.println("Exclusive time of each function call: "+Arrays.toString(ob.exclusiveTime(n,logs)));
	}
}
