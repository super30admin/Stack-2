import java.util.*;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prev = 0;

        for (String log : logs) {
            String[] logAr = log.split(":");

            int cur = Integer.parseInt(logAr[2]);

            if (logAr[1].equals("start")) {
                if (!stack.isEmpty()) {
                    //  count the time of previous process
                    result[stack.peek()] += cur - prev;
                    prev = cur;
                }

                stack.push(Integer.parseInt(logAr[0]));
            }
            else {
                result[stack.pop()] += cur - prev + 1;
                prev = cur + 1;
            }
        }

        return result;
    }
}
