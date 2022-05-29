// O(n) time: iterate through all logs
// O(n) space: for stack

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Log> stack = new ArrayDeque<>();
        int[] result = new int[n];
        for (String content : logs){
            Log log = new Log(content);
            if (log.isStart){
                stack.push(log);
            }
            else{
                Log top = stack.pop();
                result[top.id] += (log.time - top.time + 1);
                if (!stack.isEmpty()){
                    result[stack.peek().id] -= (log.time - top.time + 1);
                }
            }
        }
        return result;
    }
    
    public static class Log{
        public int id;
        public boolean isStart;
        public int time;
        
        public Log(String content){
            String[] strs = content.split(":");
            id = Integer.valueOf(strs[0]);
            isStart = strs[1].equals("start");
            time = Integer.valueOf(strs[2]);
        }
    }
}