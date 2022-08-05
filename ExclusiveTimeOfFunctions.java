import java.util.List;
import java.util.Stack;

//Time: O(n)
//Space: O(n)

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        //null case check
        if(logs == null) return new int[0];
        
        int [] result = new int [n];
        
        Stack<Integer> st = new Stack<>();
        
        int prev = 0;
        
        for(String log : logs) {
            String [] arr = log.split(":");
            
            int curr = Integer.parseInt(arr[2]);
            
            if(arr[1].equals("start")) {
                if(!st.isEmpty()) {
                    int prevTask = st.peek();
                    result[prevTask] += curr - prev;
                }
                st.push(Integer.parseInt(arr[0]));
                prev = curr;
            }else {
                if(!st.isEmpty()) {
                    result[st.pop()] += curr - prev + 1;
                }
                prev = curr + 1;
            }
        }
        return result;
    }
}