// Time Complexity : O(length of logs)
// Space Complexity : O(length of logs)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Forgot to add prev = curr + 1 when process ends

/*
Approach: Maintain id, curr, prev variables. In case when the process starts, peek the stack and on that index in the resultant array store curr - prev and assign prev equal to curr and push the current id to the stack. In case of end, pop from the stack and on that index in the resultant array store value as curr + 1 - prev and assign prev as curr + 1.
 */
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        if(n == 0){
            return new int[]{};
        }

        Stack<Integer> s = new Stack<>();
        int[] result = new int[n];
        int curr = 0;
        int prev = 0;

        for(String log: logs){

            String[] splitLog = log.split(":");
            int id = Integer.parseInt(splitLog[0]);
            curr = Integer.parseInt(splitLog[2]);

            if(!s.isEmpty() && splitLog[1].equals("start")){
                result[s.peek()] = result[s.peek()] + curr - prev;
                prev = curr;
                s.push(id);
            }
            else if(!s.isEmpty() && splitLog[1].equals("end")){
                result[s.peek()] = result[s.peek()] + curr + 1 - prev;
                prev = curr + 1;
                s.pop();
            }
            else{
                s.push(id);
            }
        }

        return result;
    }
}