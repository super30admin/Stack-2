// Time Complexity : O(N)
// Space Complexity : O(N)
import java.util.*;
public class ExclusiveTimeFunctions {
    static  int[] exclusiveTime(int n, List<String> logs) {
        int[] time = new int[n];
        int curr = 0; int prev = 0;
        Stack<Integer> stk = new Stack<>();


        for(String log: logs) {
            String[] tasks = log.split(":");
            int id = Integer.parseInt(tasks[0]);
            String status = tasks[1];
            curr = Integer.parseInt(tasks[2]);

            if(status.equals("start")) {
                if(!stk.isEmpty()) {
                    time[stk.peek()] += curr-prev;
                }
                stk.push(id);
                prev = curr;
            } else {
                time[stk.pop()] += curr-prev+1;
                prev = curr+1;
            }

        }

        return time;
    }
    public static void main(String[] args) {
        List<String> logs = new ArrayList<>(Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6"));
        System.out.println("Logs: " + logs);
        int n = 2;
        System.out.println("Exclusive time: " + Arrays.toString(exclusiveTime(n,logs)));
    }
}
