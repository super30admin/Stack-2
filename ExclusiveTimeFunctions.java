// Time Complexity : O(N), N -> number of logs
// Space Commplexity: O(k), k -> size of stack
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (n == 0 | logs.size() == 0) return new int[]{};

        Stack<Integer> s = new Stack<>();
        int curr = 0, prev = 0;
        int[] result = new int[n];

        for (String log : logs) {
            String[] strArray = log.split(":");

            curr = Integer.parseInt(strArray[2]);
            if (strArray[1].equals("start")) {
                // Start call
                if (!s.isEmpty()) {
                    result[s.peek()] += curr - prev;
                }
                int functionId = Integer.parseInt(strArray[0]);
                s.push(functionId);
                prev = curr;
            } else {
                // End call
                result[s.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }

        return result;
    }
}
