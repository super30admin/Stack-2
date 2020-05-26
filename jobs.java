// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int [] result = new int[n];
        Stack<Integer> st = new Stack<>();
        String[] s = logs.get(0).split(":");
        st.push(Integer.valueOf(s[0]));
        int time = Integer.valueOf(s[2]);
        int i = 1;
        while(i<logs.size())
        {
            s = logs.get(i).split(":");
            int temp = Integer.valueOf(s[2]);
            if(s[1].equals("start"))
            {
                if(!st.isEmpty())
                {
                    result[st.peek()] += temp  - time;
                }
                st.push(Integer.valueOf(s[0]));
                time = temp;
            }
            else
            {
                result[st.peek()] += temp  - time +1;
                st.pop();
                time = temp +1;
            }
            i++;
        }
        return result;
    }
}