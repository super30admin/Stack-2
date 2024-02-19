/* Time Complexity : O(m+n)
 *   n - no. of taskIds
 *   m - length of the list - logs */
/* Space Complexity : O(m) 
 * stack size */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//When we encounter start in a task we peek from stack and  calc the time diff and push the currId to stack and,
//when we encounter end we pop from the stack and clac the tiem diff

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        int prevTime = 0;
        for(String log: logs){
            String[] currLog = log.split(":");
            int currTaskId = Integer.parseInt(currLog[0]);
            int currTime = Integer.parseInt(currLog[2]);
            if(currLog[1].equals("start")){
                if(!st.isEmpty()){
                    res[st.peek()] += currTime - prevTime;
                }
                prevTime = currTime;
                st.push(currTaskId);
            } else {
                res[st.pop()] += currTime + 1 - prevTime;
                prevTime = currTime + 1;
            }
        }
        return res;
    }
}