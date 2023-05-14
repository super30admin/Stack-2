/**
Time Complexity - O(n) where n is the number of logs
Space Complexity - O(n)
Approach - 
            If it is an start log, we just push to the stack
            If it is an end log, means a function call ends, then the last log in the stack is the log with the same function id in "start". 
            Meanwhile if the stack is not empty, means the function just finished is inside another function called wrapper function, so this function's time is not counted into the wrapper function time. We will decrease the time in the wrapper function in advance which is the magic. So when we find the end log of the wrapper function, we can just calculate the whole time spent in wrapper function, and decrease the time does not belongs to the wrapper function.
 */
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Log> stack = new ArrayDeque<>();
        int[] result = new int[n];
        int duration = 0;

        for (String content : logs) {
            Log log = new Log(content);
            if (log.isStart)
                stack.push(log);
            else {
                Log top = stack.pop();
                result[top.id] += (log.time - top.time + 1 - top.subDuration);
                if (!stack.isEmpty())
                    stack.peek().subDuration += (log.time - top.time + 1);
            }
        }
        return result;
    }
    
    public static class Log {
        public int id;
        public boolean isStart;
        public int time;
        public int subDuration;
        
        public Log(String content) {
            String[] strs = content.split(":");
            id = Integer.valueOf(strs[0]);
            isStart = strs[1].equals("start");
            time = Integer.valueOf(strs[2]);
            subDuration = 0;
        }
    }
}
