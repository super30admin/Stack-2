// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Coded after the lecture.


// Your code here along with comments explaining your approach

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int prev = 0;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for(String log: logs)
        {
            String[] s = log.split(":");
            int pid = Integer.valueOf(s[0]);
            String state = s[1];
            int curr = Integer.valueOf(s[2]);
            if(state.equals("start"))
            {
                if(!st.isEmpty())
                {
                    result[st.peek()] +=curr - prev;
                }
                st.push(pid);
                prev = curr;
            }
            else
            {                
                result[st.pop()] += curr-prev+1;                
                prev= curr+1;
            }
        }
        return result;
    }
}