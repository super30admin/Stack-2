import java.util.List;
import java.util.Stack;

public class Problem1 {
    // TC : O(n)
    // SC : O(n)
    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null || n == 0) return new int[]{};

        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();
        int prev = 0;
        for (String log : logs) {
            String[] splitArray = log.split(":");
            int curr = Integer.parseInt(splitArray[2]);
            if (splitArray[1].equals("start")) {
                if (!s.isEmpty()) {
                    result[s.peek()] += curr - prev;
                }
                s.push(Integer.parseInt(splitArray[0]));
                prev = curr;
            } else {
                result[s.pop()] += (curr + 1) - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}
