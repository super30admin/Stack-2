import java.util.List;
import java.util.Stack;

public class ExclusiveTimeFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null || logs.size() == 0) return new int[]{};

        int[] res = new int[n];
        Stack<Integer> stack = new Stack();
        int prev = 0, curr = 0;

        for(String s : logs) {
            String[] strs = s.split(":");
            int id = Integer.valueOf(strs[0]);
            String process = strs[1];
            int time = Integer.valueOf(strs[2]);

            curr = time;

            if(process.equalsIgnoreCase("start")) {
                if(!stack.isEmpty()) {
                    int index = stack.peek();
                    res[index] = res[index] + (curr - prev);
                }
                stack.push(id);
                prev = curr;
            } else {
                if(!stack.isEmpty()) {
                    int index = stack.pop();
                    res[index] = res[index] + (curr + 1 - prev);
                }
                prev = curr + 1;
            }
        }

        return res;
    }
}
