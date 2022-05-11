// Time Complexity : O(max(n,logs))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding that we should use stack


// Your code here along with comments explaining your approach

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null) return new int[0];
        Stack<Integer> tasks = new Stack<>();
        int result[] = new int[n];
        int curr = 0;
        int prev = 0;
        for(String log: logs){
            String splitLog[] = log.split(":");
            int taskId = Integer.parseInt(splitLog[0]);
            curr = Integer.parseInt(splitLog[2]);
            if(splitLog[1].equals("start")){
                if(!tasks.isEmpty()){
                    result[tasks.peek()] += curr - prev;
                }
                tasks.push(taskId);
                prev = curr;
            } else { // end process
                result[tasks.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}