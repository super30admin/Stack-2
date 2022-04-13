// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We will maintain a stack which will keep track start ids of functions
// Now we will calculate the time intervals between start and end, start between 2 fnId, and ends
// Whenever we see a new action we will update the result as per the time difference
// This we can achieve using the previous time variable.
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int prevTime = 0;
        int[] ans = new int[n];
        for(String str: logs){
            String[] log = str.split(":");
            int id = Integer.parseInt(log[0]);
            String action = log[1];
            int time = Integer.parseInt(log[2]);
            if(action.equals("start")){
                if(!st.isEmpty()){
                    ans[st.peek()] += time - prevTime;
                }
                st.push(id);
                prevTime = time;
            }
            else{
                ans[st.pop()] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }
        return ans;
    }
}