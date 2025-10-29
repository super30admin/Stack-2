/*
636. Exclusive Time of Functions
Ran on leetcode: Yes
TC: O(N) N is logs
SC: O(N)
Traverse logs if it is start process push the process onto the stack, if there is already a process on the stack store the time units consumed by it and if it is end pop the process out of the stack and store the time unit consumed by it.
*/
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        
        int prev = 0;

        for(String log: logs){
            String[] splitLog = log.split(":");
            int processId = Integer.parseInt(splitLog[0]);
            String status = splitLog[1];
            int curr = Integer.parseInt(splitLog[2]);
            
            if(status.equals("start")){
                if(!st.isEmpty()){ // if there is another process coming in store the result for previous process
                    result[st.peek()] += curr - prev; // calculate the time unit and store it in the process which is being stopped by new process
                }
                st.push(processId); // Push the new process
            } else if(status.equals("end")){
                curr++; // we need to consume the time unit completely, move ahead by 1
                result[st.pop()] += curr - prev; // calculate the time unit
            }
            prev = curr;
        }

        return result;
    }
}