package stacks2;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
	//Time Complexity : O(l), where l are the number of logs
	//Space Complexity : O(l), for stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        int prev = 0;
        for(String s: logs) {
            String[] log = s.split(":");
            int processId = Integer.parseInt(log[0]);
            int curr = Integer.parseInt(log[2]);
            if(log[1].equals("start")) {
                if(!stack.isEmpty()) {
                    res[stack.peek()] += curr - prev;
                    prev = curr;
                }
                stack.push(processId);
            } else {
                res[stack.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        
        return res;
    }
}
