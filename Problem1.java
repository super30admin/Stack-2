// Time Complexity: O(N) N: Number of logs
// Space Complexity: O(N)
// Passed Leetcode

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] output = new int[n];
        int curr;
        int prev = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < logs.size(); i++) {
            
            String[] rec = logs.get(i).split(":");
            
            curr = Integer.parseInt(rec[2]);
            if (rec[1].equals("start")) {
                
                if (!stack.isEmpty()) {
                    output[stack.peek()] += curr - prev;
                }
                
                stack.push(Integer.parseInt(rec[0]));
                prev = curr;
                
            } else {
                
                output[stack.peek()] += curr - prev + 1;
                stack.pop();
                prev = curr + 1;
            }
            
        }
        return output;
    }
}