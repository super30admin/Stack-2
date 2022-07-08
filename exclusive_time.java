// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int l = logs.size();
        int[] result = new int[n];
        int prev = 0;
        int curr = 0;
        Stack<Integer> st = new Stack<>();
        if (logs == null || logs.size() == 0)
            return result;

        for (String log : logs) {
            String[] logArr = log.split(":");
            // if it is a start log
            curr = Integer.parseInt(logArr[2]);
            if (logArr[1].equals("start")) {

                if (!st.isEmpty()) {

                    result[st.peek()] += curr - prev;
                }
                int id = Integer.parseInt(logArr[0]);
                st.push(id);
                prev = curr;
            }
            else if (logArr[1].equals("end")) {
                // we'll add time in the task which is already started
                result[st.pop()] += curr - prev + 1;
                // prev will be curr+1 because at end we consider end of time unit
                prev = curr + 1;
            }

        }
        return result;
    }
}