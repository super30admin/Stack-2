//Time complexity: O(n)
//Space complexity: O(n)

import java.util.*;

class Solution1 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] output = new int[n]; 
        int time = 0;
        Stack<Integer> stack = new Stack<>();
        //iterate through logs
        for(String log: logs) {
            String[] l = log.split(":"); 
            int id = Integer.parseInt(l[0]);
            int timestamp = Integer.parseInt(l[2]);
            //start
            if (l[1].equals("start")) {
                if (!stack.isEmpty()) {
                    output[stack.peek()] += timestamp - time;
                    time = timestamp;
                }
                stack.push(id);
            }
            //end
            else {
                output[stack.pop()] += timestamp - time + 1;
                time = timestamp+1;
            }
        }
        
        return output; 
    }
}