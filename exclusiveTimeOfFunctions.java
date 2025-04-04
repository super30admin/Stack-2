// Problem2 Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, for each log take task as str[0] and curr as str[2] and check if str[1].equals("start"), if yes and if stack is not empty, result[st.peek]
 * += curr - prev and push task into st and move prev to curr. Else, take the top element out and result[popped] += curr+1 - prev and move
 * prev to curr+1. Finally return result.
 */
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int []result = new int[n];
        Stack<Integer> st = new Stack<>();
        int curr = 0;
        int prev = 0;
        for(String log: logs){
            String []str = log.split(":");
            int taskId = Integer.parseInt(str[0]);
            curr = Integer.parseInt(str[2]);
            if(str[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }
                st.push(taskId);
                prev = curr;
            }
            else{
                int popped = st.pop();
                result[popped] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}