// Time Complexity : O(n)
// Space Complexity : O(H) H is height of Stack
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach: We use a Stack in order to simulate a function call stack. When a function's start arrives, we push it onto our stack and whenever it either finishes or another process arrives, we pop and add current runtime to the existing runtime (if any) for the current process.

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimes {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (n == 0 || logs == null || logs.size() == 0) {
            return new int[] {};
        }

        Stack<Integer> s = new Stack<>(); // simulate function stack
        int prev = 0, curr = 0; // track start times of curr and prev process
        int[] res = new int[n]; // final timings

        // start processor
        for (int i = 0; i < logs.size(); i++) {
            String l = logs.get(i);
            // obtain parts of the log
            String[] log = l.split(":"); // pid:operation:time

            curr = Integer.parseInt(log[2]); // time of current process

            if (log[1].equals("start")) { // process start
                if (!s.isEmpty()) {
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

    public static void main(String[] args) {
        ExclusiveTimes exclusiveTimes = new ExclusiveTimes();

        int n = 2;
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");

        int[] result = exclusiveTimes.exclusiveTime(n, logs);

        System.out.println("Exclusive Times:");
        for (int i = 0; i < n; i++) {
            System.out.println("Function " + i + ": " + result[i]);
        }
    }
}
