package Stack2;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    /* Created by palak on 8/3/2021 */

    /**
     Time Complexity: O(n)
     Space Complexity: O(n)
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>(); //task stack
        int[] result = new int[n];
        int prev = 0; //prev initially at 0 index
        for(String log: logs) {
            String[] arr = log.split(":");
            int curr = Integer.parseInt(arr[2]);
            if(arr[1].equals("start")) {
                if(!stack.isEmpty()) {
                    result[stack.peek()] += curr - prev; //record the already used time by my previous task
                }
                prev = curr;
                stack.push(Integer.parseInt(arr[0])); // pushing the task
            } else {
                result[stack.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}
