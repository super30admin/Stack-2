
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;

class Main {

    public static int[] exclusiveTime(int n, List<String> logs) {
        // null case
        if (n == 0 || logs == null)
            return new int[] {};
        // result array
        int[] result = new int[n];
        // stack for getting currently running task
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        for (String log : logs) {
            // split the string
            String[] strArr = log.split(":");
            int curr = Integer.parseInt(strArr[2]);
            // first get currently running task from stack if incoming log is start
            // another task so update currently running time of the tasl
            if (strArr[1].equals("start")) {
                if (!st.isEmpty()) {
                    result[st.peek()] += curr - prev;
                }
                // update the previous
                prev = curr;
                // push current task in the stack
                st.push(Integer.parseInt(strArr[0]));
            } else {
                // if any task ends pop from the stack and update time taken by that task
                result[st.pop()] += curr - prev + 1;
                // update the previous
                prev = curr + 1;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        List<String> logs = Arrays.asList(new String[] { "0:start:0", "1:start:2", "1:end:5", "0:end:6" });
        int n = 2;
        System.out.println(Arrays.toString(exclusiveTime(n, logs)));
    }
}