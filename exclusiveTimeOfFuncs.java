// TC - O(n)
// SC - O(n) for Stack

/*
 * Approach
 * We use a Stack in order to simulate a function call stack. When a function's
 * start arrives, we push it onto our stack and whenever it either finishes or
 * another process arrives, we pop and add current runtime to the existing
 * runtime (if any) for the current process.
 */

import java.util.*;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(n == 0 || logs == null || logs.size() == 0) {
            return new int[] {};
        }

        Stack<Integer> s = new Stack<>(); // simulate function stack
        int prev = 0, curr = 0; // track start times of curr and prev process
        int[] res = new int[n]; // final timings

        // start processor
        for(int i=0; i<logs.size(); i++) {
            String l = logs.get(i);
            // obtain parts of the log
            String[] log = l.split(":"); // pid:operation:time

            curr = Integer.parseInt(log[2]); // time of current process

            if(log[1].equals("start")) { // process start
                if(!s.isEmpty()) {
                    res[s.peek()] += curr - prev;
                }
                prev = curr; // move to next process
                s.push(Integer.parseInt(log[0])); // add to function stack
            } else { // process end
                int pid = s.pop();
                res[pid] += curr - prev + 1; // record end time of process
                prev = curr + 1; // record the end of timeslot at the end of process
            }
        }

        return res;
    }
}