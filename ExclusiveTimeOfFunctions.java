// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        int prev = 0;
        int curr = 0;

        for(String log : logs){
            String[] split = log.split(":");
            curr = Integer.parseInt(split[2]);
            if(split[1].equals("start")){
                if(!stack.isEmpty()){
                    result[stack.peek()] += curr - prev;
                }
                stack.push(Integer.parseInt(split[0]));
                prev = curr;
            } else {
                result[stack.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }

        return result;
    }
}
