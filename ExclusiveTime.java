//Time Complexity: O(n)
//Space Complexity: O(n)

import java.util.List;
import java.util.Stack;

public class ExclusiveTime {
	public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prev = 0;
        for(String log: logs){
            String[] arr = log.split(":");
            int curr = Integer.parseInt(arr[2]);
            if(arr[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }
                prev = curr;
                st.push(Integer.parseInt(arr[0]));
            } else {
                result[st.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        return result;
    }
}
