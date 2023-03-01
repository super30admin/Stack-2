// Time Complexity : O(n) where n=length of logs array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// When we come across start task, push into stack and update stack top element's time
// Keep track of prev and curr pointers which should be updated as start and end of time blocks
// Stack will keep track of which task to update time for 

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int prev = -1; int[] res = new int[n];
        for(String log: logs){
            String[] strArr = log.split(":");
            int curr = Integer.parseInt(strArr[2]);
            if(strArr[1].equals("start")){
                if(!st.isEmpty()) res[st.peek()] += curr-prev;
                st.push(Integer.parseInt(strArr[0]));
                prev = curr;
            }
            else{
                res[st.pop()] += curr-prev+1;
                prev=curr+1;
            }
        }
        return res;
    }
}