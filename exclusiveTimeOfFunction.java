// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class exclusiveTimeOfFunction {
    class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {

            int[] result = new int[n];
            Stack<Integer> stack = new Stack<>();
            int prev = 0;
            for(String log : logs){
                String[] splitArr = log.split(":");
                int currTaskId = Integer.parseInt(splitArr[0]);
                int currTime = Integer.parseInt(splitArr[2]);

                if(splitArr[1].equals("start")){
                    if(!stack.isEmpty()){
                        result[stack.peek()] += currTime - prev;
                    }
                    prev = currTime;
                    stack.push(currTaskId);
                }
                else{
                    result[stack.pop()] += currTime - prev + 1;
                    prev = currTime + 1;
                }
            }
            return result;
        }
    }
}
