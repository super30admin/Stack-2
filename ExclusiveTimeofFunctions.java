class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (n == 0) {
            return new int[] {};
        }

        Stack<Integer> stack = new Stack<>();
        int result[] = new int[n];
        int prev = 0;
        int cur = 0;
        for (String log : logs) {
            String arr[] = log.split(":");
            int id = Integer.parseInt(arr[0]);
            String when = arr[1];
            cur = Integer.parseInt(arr[2]);

            if (when.equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += (cur - prev);
                }
                stack.push(id);
                prev = cur;
            } else {
                result[stack.pop()] += (cur - prev + 1);
                prev = cur + 1;
            }
        }

        return result;
        
    }
}