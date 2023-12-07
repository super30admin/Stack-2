// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int prev = 0;
        Stack<Integer> stk = new Stack<>();
        for(String log : logs){
            String[] curr = log.split(":");
            int current = Integer.parseInt(curr[2]);
            
            if(curr[1].equals("start")){
                if(!stk.isEmpty())
                res[stk.peek()]+=current - prev;
                prev = current;
                stk.push(Integer.parseInt(curr[0]));
            }else if(curr[1].equals("end")){
                res[stk.pop()]+=current - prev + 1;
                prev = current + 1;
            }
        }
        return res;
    }
}