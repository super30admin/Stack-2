//time o(n)
//space o(n) stack space
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null || logs.size() == 0)
            return new int[0];
        
        int[] res = new int[n];
        int prevTime=0;
        
        //stack to parent process ID
        Stack<Integer> stack = new Stack<>();
        for(String log : logs) {
            String[] arr = log.split(":");
            int curTime = Integer.parseInt(arr[2]);
            if(!stack.isEmpty()) {
                if(arr[1].equals("start")) {
                    res[stack.peek()] += curTime - prevTime;
                    stack.push(Integer.parseInt(arr[0]));
                    prevTime = curTime;
                }
                else {
                    res[stack.pop()] += curTime - prevTime + 1;
                    prevTime = curTime + 1; 
                }
            }
            else {
                stack.push(Integer.parseInt(arr[0]));
                prevTime = curTime;
            }
        }
        return res;
    }
}