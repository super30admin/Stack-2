// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.List;
import java.util.Stack;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int currTime = 0;
        int prevTime = 0;
        int[] result = new int[n];
        for (String log : logs) {
            String[] strArr = log.split(":");
            currTime = Integer.parseInt(strArr[2]);
            if (strArr[1].equals("start")) {
                if (!st.isEmpty()) {
                    result[st.peek()] += currTime - prevTime;
                    prevTime = currTime;
                }
                st.push(Integer.parseInt(strArr[0]));
            } else {
                result[st.pop()] += currTime + 1 - prevTime;
                prevTime = currTime + 1;
            }
        }

        return result;
    }
}