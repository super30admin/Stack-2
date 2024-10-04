// Time complexity = O(n)// iterating through each element of logs. (logs size.)
// Space complexity = O(n)  // Stack. no. of logs 
// Why stack -> order . we need to maintain order of logs.
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack= new Stack<>();
        int[] res = new int[n];
        // these are just 2 pointers to iterate through logs and capture the time.
        int prev =0;
        int curr =0;
        for(String log: logs) {
            String[] logStr = log.split(":");// 0:start:0
            curr = Integer.parseInt(logStr[2]);
            if(logStr[1].equals("start")) {
                if(!stack.isEmpty()) {
                    res[stack.peek()]+=curr-prev;                    
                }
                stack.push(Integer.parseInt(logStr[0]));
                prev = curr;
            } else  {// it is end. so pop.
                res[stack.pop()]+= curr+1-prev;// why curr+1-prev, since the end of the log is the start of the log. so we need to account for that as well.
                prev = curr+1;
            }
            
            
        }
        return res;
        
        
    }
}