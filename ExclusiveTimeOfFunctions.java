// Time Complexity : O(n)  -> n is the number of logs (maximum between logs and tasks)
// Space Complexity : O(n/2) -> half the logs
// Did this code successfully run on Leetcode : Yes

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int prevTime = 0;

        for(int i=0; i<logs.size(); i++){
            String[] process = logs.get(i).split(":");
            int currTask = Integer.parseInt(process[0]);
            int currTime = Integer.parseInt(process[2]);

            if(process[1].equals("start")){
                //pause the prev currTask
                if(!st.isEmpty()){
                    result[st.peek()] += currTime - prevTime;
                }
                st.push(currTask);
                prevTime = currTime;
            }else{
                currTime = currTime + 1;
                result[st.pop()] += currTime - prevTime;
                prevTime = currTime;
            }
        }
        return result;
    }
}
