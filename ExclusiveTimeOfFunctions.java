//The approach here is to utilize a stack because the order of the timings of start and end of a function is essential
//For every function, we check if it's a start function, if it is, then we push into stack and we add time of the paused function
//For every end function, we add corresponding time for the start function by popping it out and we take 1 extra because it is the end of function and it occupies that time 
//To achieve this and to add time log for each function, we take two pointers, prev and curr
//Time Complexity: O(n) where n is the number of logs
//Space Complexity: O(n) extra space
import java.util.List;
import java.util.Stack;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int curr = 0; int prev = 0;
        for(String log: logs){
            String[] strArr = log.split(":");
            int taskId = Integer.parseInt(strArr[0]);
            curr = Integer.parseInt(strArr[2]);
            if(strArr[1].equals("start")){
                //start log
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }
                st.push(taskId);
                prev = curr;
            } else {
                int poppedTask = st.pop();
                result[poppedTask] += curr + 1 - prev;
                prev = curr+1;
            }
        }
        return result;
    }
}
