// TC: O(n)
// SC: O(n)
class ExclusiveTimeFunc {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();

        for(String log : logs) {
            String[] s = log.split(":");
            int idx = Integer.valueOf(s[0]);
            int t = Integer.valueOf(s[2]);
            // start
            if(s[1].equals("start")) {
                stack.push(new int[]{idx, t});
            } 
            // end
            else {
                int v = t-stack.pop()[1]+1;
                // Subtract from v from the index
                res[idx] += v;
                // Check if stack is not empty then just subtract v from the array[stack_peek_index] 
                if(!stack.empty()) 
                    res[stack.peek()[0]] -= v;
            }
        }
        return res;
    }
}