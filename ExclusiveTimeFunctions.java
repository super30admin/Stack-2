import java.util.List;
import java.util.Stack;

public class ExclusiveTimeFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        int prev = 0;

        int[] result = new int[n];
        final Stack<Integer> stack = new Stack<>();

        for (final String log: logs) {
            final String[] split = log.split(":");

            final int taskId = Integer.parseInt(split[0]);
            final int current = Integer.parseInt(split[2]);

            if (split[1].equals("start")) {
                if (!stack.isEmpty()) result[stack.peek()] += current - prev;
                prev = current;
                stack.push(taskId);
            } else {
                result[stack.pop()] += current + 1 - prev;
                prev = current + 1;
            }
        }

        return result;
    }
}
