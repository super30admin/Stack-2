// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// We note the current and previous time stamps of each process
// At the start of a process, we pause the previous process in stack and add the time taken to it and push the new process into the stack
// At the end of a process, we pop and add the time taken from the previous timestamp and add a extra 1 to compensate the end time stamp property  

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Deque<Integer> st = new ArrayDeque();
        int prev = 0;
        int curr = 0;
        for (String str : logs) {
            String[] s = str.split(":");
            curr = Integer.parseInt(s[2]);
            if (s[1].equals("start")) {
                if (!st.isEmpty())
                    result[st.peek()] += curr - prev;
                st.push(Integer.parseInt(s[0]));
                prev = curr;
            } else {
                result[st.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}