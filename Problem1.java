import java.util.*;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (n == 0 || logs == null || logs.size() == 0) {
            return new int[] {};
        }

        Stack<Integer> s = new Stack<>();
        int prev = 0, curr = 0;
        int[] res = new int[n];

        for (int i = 0; i < logs.size(); i++) {
            String l = logs.get(i);

            String[] log = l.split(":");

            curr = Integer.parseInt(log[2]);
            if (log[1].equals("start")) {
                if (!s.isEmpty()) {
                    res[s.peek()] += curr - prev;
                }
                prev = curr;
                s.push(Integer.parseInt(log[0]));
            } else {
                int pid = s.pop();
                res[pid] += curr - prev + 1;
                prev = curr + 1;
            }
        }

        return res;
    }
}