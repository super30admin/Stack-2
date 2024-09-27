// Time complexity: O(N)
// Space complexity: O(N)

import java.util.*;
class Solution {

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prev = 0;
        
        for(String log: logs)
        {
            String[] arr = log.split(":");
            int curr = Integer.parseInt(arr[2]);
            if(arr[1].equals("start"))
            {
                if(!st.isEmpty())
                {
                    result[st.peek()] += curr - prev;
                }
                st.push(Integer.parseInt(arr[0]));
                prev = curr;
            }
            else
            {
                result[st.peek()] += curr - prev+1;
                st.pop();
                prev = curr + 1;
            }

        }
        return result;
        
        
    }
}