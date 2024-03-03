import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    // TC: O(N) where N is length of logs
    // SC: O(N) where N is length of logs
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[n];
        for (int i = 0; i < logs.size(); i++) {
            String curr = logs.get(i);
            String[] parts = curr.split(":");
            int key = Integer.valueOf(parts[0]);
            int value = Integer.valueOf(parts[2]);
            if (parts[1].equals("start")) {
                if (!stack.isEmpty()) {
                    int[] peek = stack.peek();
                    res[peek[0]] += value - peek[1];
                }
                stack.push(new int[]{key, value});
            } else {
                int[] pop = stack.pop();
                res[key] += value - pop[1] + 1;
                if (!stack.isEmpty()) {
                    int[] peek = stack.peek();
                    peek[1] = value + 1;
                }
            }
        }
        return res;
    }
}
