Time Complexity (TC): O(m), where m is the number of logs, as we iterate through the logs once and perform constant-time operations for each.
Space Complexity (SC): O(n), where n is the number of functions, due to the stack storing active function indices.

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int prev = 0;
        int[] res = new int[n];
        for (String log : logs) {
            String[] arr = log.split(":");
            int currentTime = Integer.parseInt(arr[2]);
            String state = arr[1];
            int event = Integer.parseInt(arr[0]);
            if (state.equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += currentTime - prev;
                }
                prev = currentTime;
                stack.push(event);
            } else {
                res[stack.pop()] += currentTime + 1 - prev;
                prev = currentTime + 1;
            }
        }
        return res;
    }
}