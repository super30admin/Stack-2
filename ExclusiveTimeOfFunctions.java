// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes


import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prev =0;

        for(String log: logs){
            String[] logsArray = log.split(":");
            int processId = Integer.parseInt(logsArray[0]);
            String processType = logsArray[1];
            int curr = Integer.parseInt(logsArray[2]);

            if(processType.equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr-prev;
                }
                st.push(processId);
            }else{
                curr = curr+1;
                result[st.pop()] += curr-prev;
            }
            prev = curr;
        }

        return result;
    }
}
