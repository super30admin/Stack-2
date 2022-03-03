import java.util.List;
import java.util.Stack;

public class Intervals {
    // TC O(N)
    // SC O(N)
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stk = new Stack<>();
        int prev = 0;
        int[] res = new int[n];
        for (String log : logs) {
            String[] splitArr = log.split(":");
            int curr = Integer.parseInt(splitArr[2]);
            if (splitArr[1].equals("start")) {
                if (!stk.isEmpty()) {
                    res[stk.peek()] += curr - prev;
                    prev = curr;
                }
                int id = Integer.parseInt(splitArr[0]);
                stk.push(id);
            } else {
                res[stk.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return res;
    }
}
