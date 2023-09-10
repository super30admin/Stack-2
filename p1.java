// Time Complexity :O(l) where l is logs.length
// Space Complexity :O(l) where l is logs.length
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        int prev = 0;
        Stack<Integer> stk = new Stack<>();
        for(String log: logs){
            String[] slog = log.split(":");
            int curr = Integer.parseInt(slog[2]);
            int task = Integer.parseInt(slog[0]);
            //If we have start in the log
            if(slog[1].equals("start")){
                //if stack is empty
                if(!stk.isEmpty()){
                    result[stk.peek()] += curr-prev;
                }
                stk.push(task);
                prev = curr;
            }
            //If we have start in the log
            else{
                result[stk.pop()] += curr+1 - prev;
                prev = curr+1;
            }
        }
        return result;
    }
}