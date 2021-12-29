//time O(n)
//space O(n)

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int curr = 0;
        int prev = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(String log: logs) {
            String[] logArr = log.split(":");
            int id = Integer.parseInt(logArr[0]);
            int timestamp = Integer.parseInt(logArr[2]);
            curr = timestamp;
            if(logArr[1].equals("start")) {
                if(!stack.isEmpty()) {
                    res[stack.peek()] += (curr - prev);
                }
                stack.push(id);
                prev = curr;
            } else {
                res[stack.pop()] += (curr+1 - prev);
                prev = curr+1;
            }
        }
        
        return res;
        
    }
}
