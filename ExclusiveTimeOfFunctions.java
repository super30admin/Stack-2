import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();

        int prev = 0;
        int[] res = new int[n];

        for (String log : logs) {
            String[] splitArr = log.split(":");
            int processId = Integer.parseInt(splitArr[0]);
            String processType = splitArr[1];
            int curr = Integer.parseInt(splitArr[2]); // time

            if (processType.equals("start")) {
                if (!st.isEmpty()) {
                    res[st.peek()] += curr - prev;
                }
                st.push(processId);
            } else {
                curr = curr + 1;
                res[st.pop()] += curr - prev;
            }
            prev = curr;
        }
        return res;
    }
}

//TC: O(n), SC: O(n)
