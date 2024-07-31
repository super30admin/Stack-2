//time complexity:o(n)
//space complexity :o(n)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExecutiveTimeFunction {
    public int[] exclusiveTime(int n, List<String> logs) {
        int prev = 0;
        int curr = 0;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for (String log : logs) {
            String[] record = log.split(":");
            curr = Integer.parseInt(record[2]);
            if (record[1].equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += curr - prev;
                }
                stack.push(Integer.parseInt(record[0]));
                prev = curr;
            } else {
                result[stack.peek()] += curr - prev + 1;
                stack.pop();
                prev = curr + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ExecutiveTimeFunction e = new ExecutiveTimeFunction();
        int n = 2;
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");
        int[] ans = e.exclusiveTime(n, logs);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
