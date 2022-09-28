//TC: O(N) iterating through the logs
//SC : O(n) no.of tasks

// Approach: A stack is used to store the tasks and make two variables curr, prev
//while iterating through each log, if it is "start", add to the stack and before that update the result of the stackpeek value as curr-prev and prev = curr
//if it is end, pop the value and make that popped value result to be curr_+1-prev and prev = curr+1 as effective current 
public class Exclusive_Time_of_Functions {
    class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            if(logs == null )
                return new int[0];
            int [] result = new int[n];
            int prev =0;
            Stack<Integer> st = new Stack<>();
            for(String log : logs){
                String [] arr = log.split(":"); // {0:start:3} to [0,start,3]
                int curr = Integer.parseInt(arr[2]);
                int task = Integer.parseInt(arr[0]);
                
                if(arr[1].equals("start")){
                    if(!st.isEmpty())
                        result[st.peek()] += curr-prev;
                    prev = curr;
                    st.push(task);
                }
                else{
                    result[st.pop()] += curr+1-prev;
                    prev =curr+1;
                }
            }
            return result;
        }
    }
}
