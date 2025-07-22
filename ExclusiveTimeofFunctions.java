// TC: O(n)
// SC: O(n)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        int curr = 0;
        int prev = 0;
        Stack<Integer> st = new Stack<Integer>();

        for (String log : logs) {
            String[] splitLog = log.split(":");
            int pid = Integer.parseInt(splitLog[0]);
            curr = Integer.parseInt(splitLog[2]);

            if (splitLog[1].equals("start")) {
                if (!st.isEmpty()) {
                    result[st.peek()] = result[st.peek()] + (curr - prev);
                }
                prev = curr;
                st.push(pid);
            } else {
                int poppedId = st.pop();
                result[poppedId] = result[poppedId] + (curr + 1 - prev);
                prev = curr + 1;
            }
        }

        return result;
    }
}