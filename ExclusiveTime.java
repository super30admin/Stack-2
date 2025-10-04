class Solution {
    //Use a stack to store all the processes that have started, add pause times to result array and 
    //remove them from stack when the process ends.Stack is used to maintain the order of
    //processes that are started and paused
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prev = 0;

        for(String log:logs)
        {
            String[] splitArr = log.split(":");
            int processId = Integer.ParseInt(splitArr[0]);
            String processType = splitArr[1];
            int curr = Integer.ParseInt(splitArr[2]);

            if(processType.equals("start"))
            {
                if(!st.IsEmpty())
                {
                    result[st.peek()] += curr - prev;
                }
                st.push(processId);
            }
            else
            {
                curr = curr+1;
                result[st.pop()] += curr - prev;
            }
            prev = curr;
        }
        return result;
    }
}