/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(n)
* 
*/

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> st = new Stack<>();

        int[] result = new int[n];

        for (int index = 0; index < logs.size(); index++) {
            String[] splitStr = logs.get(index).split(":");

            int id = Integer.parseInt(splitStr[0]);

            int time = Integer.parseInt(splitStr[2]);

            if (splitStr[1].equals("start")) {
                if (!st.isEmpty()) {
                    result[st.peek()[0]] += time - st.peek()[1];
                }
                st.push(new int[] { id, time });
            } else {
                int[] poppedElement = st.pop();
                result[poppedElement[0]] += (time - poppedElement[1] + 1);
                if (!st.isEmpty()) {
                    int[] top = st.peek();
                    top[1] = time + 1;
                }
            }
        }

        return result;
    }
}