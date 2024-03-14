import java.util.*;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        // Tc: O(n) Sc: O(n)
        if (logs == null)
            return new int[0];
        int res[] = new int[n];

        int prev = 0;

        Stack<Integer> st = new Stack<>();
        for (String log : logs) {
            String[] arr = log.split(":"); // ["0", "start", "0"]
            int curr = Integer.parseInt(arr[2]);

            if (arr[1].equals("start")) {
                if (!st.isEmpty()) {
                    res[st.peek()] += curr - prev;
                }
                st.push(Integer.parseInt(arr[0]));
                prev = curr;
            }

            else {
                res[st.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        return res;
    }
}