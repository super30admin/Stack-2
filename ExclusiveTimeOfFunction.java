
// Time complexity : O(n)
// Space complexity : O(n)
import java.util.*;

class ExclusiveTimeOfFunction {
    public static void main(String[] args) {
        int n = 2;
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("0:start:2");
        logs.add("0:end:5");
        logs.add("1:start:6");
        logs.add("1:end:6");
        logs.add("0:end:7");
        int[] result = exclusiveTime(n, logs);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null || logs.size() == 0)
            return null;
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        int prev = 0;
        int[] result = new int[n];
        for (String log : logs) {
            String[] strArr = log.split(":");
            int currId = Integer.parseInt(strArr[0]);
            curr = Integer.parseInt(strArr[2]);
            if (strArr[1].equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += curr - prev;
                }
                stack.add(currId);
                prev = curr;
            } else {
                result[stack.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}