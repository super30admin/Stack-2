package Dec22;

import java.util.List;
import java.util.Stack;

class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        // Time complexity: O(logs.size)
        // Space complexity: O(n) as are putting task IDs inside the stack.
    
        //edge
        if (logs == null || logs.size() == 0) 
            return new int[0];
        
        int[] result = new int[n];
        int prev = 0;
        Stack<Integer> st = new Stack<>(); // used to store task IDs only
        
        for(String log: logs) {
            String [] splitLog = log.split(":");  // [0,'start',0]
            int curr = Integer.parseInt(splitLog[2]); // getting timestamp for current task
            if (splitLog[1].equals("start")) {
                if (!st.isEmpty()) {
                    result[st.peek()] += curr - prev;
                    prev = curr;
                }
                st.push(Integer.parseInt(splitLog[0]));
            } 
            // splitLog[1].equals("end")
            else {
                int poppedIndex = st.pop();  // start time of the current task for which we are processing end entry
                result[poppedIndex] += curr - prev + 1; // total time taken by a task is beginning of start timestamp number to end of end timestamp number, so we have to add an extra 1 to accomodate this.
                prev = curr + 1; // because a task ended when the system time is at the end of the task timestamp, so we need to an extra 1 to prev. A task ending at 5 => next job will start/resume from beginning of 6 and not 5.
            }
        }
        
        return result;
    }
}
