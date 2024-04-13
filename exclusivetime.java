// TC =O(n)
// SC =O(n)

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] rst = new int[n];
        Stack<Integer> stack = new Stack<>();
        int timestamp = 0;
        for (String log : logs) {
            String[] parts = log.split(":");
            int task = Integer.parseInt(parts[0]);
            boolean start = parts[1].equals("start");
            int time = Integer.parseInt(parts[2]);
            if (!stack.isEmpty()) rst[stack.peek()] += time - timestamp;
            timestamp = time;
            
            if (start) stack.push(task);
            else {
                int endTask = stack.pop();
                rst[endTask] += 1; 
                timestamp++;
            }
        }
        return rst;
    }
}