// Time Complexity: (O(m)), where m is the number of logs.
// Space Complexity: (O(n + m)), where (n is the number of tasks and m is the number of logs.

import java.util.List;
import java.util.Stack;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();

        int[] result = new int[n];
        int prev = 0;

        for(String log: logs)
        {
            String[] splitArr = log.split(":");
            int curr = Integer.parseInt(splitArr[2]);

            int task = Integer.parseInt(splitArr[0]);

            if(splitArr[1].equals("start"))
            {
                //pause the previous task in the stack and record it's type'
                if(!st.isEmpty())
                {
                    result[st.peek()] += curr - prev;
                }
                prev = curr;
                st.push(task);
            }
            else
            {
                //it will be end log
                //finish that task
                result[st.pop()] += curr+1-prev;
                prev = curr+1;
            }

        }
        return result;

    }
}