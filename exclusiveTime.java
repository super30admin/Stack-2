import java.util.*;

class Pair {
    int key;
    int startTime;

    public Pair(int key, int startTime) {
        this.key = key;
        this.startTime = startTime;
    }
}

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Pair> st = new Stack<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] values = log.split(":");
            int key = Integer.parseInt(values[0]);
            String status = values[1];
            int time = Integer.parseInt(values[2]);

            if (status.equals("start")) {
                if (!st.isEmpty()) {
                    res[st.peek().key] += time - prevTime;
                }
                st.push(new Pair(key, time));
                prevTime = time;
            } else {
                Pair p = st.pop();
                res[p.key] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }

        return res;
    }
}
