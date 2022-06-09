/*
Problem: https://leetcode.com/problems/exclusive-time-of-functions/
*/
enum LogType {START, END};

class Log {
    int processId;
    LogType type;
    int timestamp;
    
    public Log(String id, String type, String time) {
        this.processId = Integer.parseInt(id);
        this.type = type.equals("start") ? LogType.START : LogType.END; 
        this.timestamp = Integer.parseInt(time);
    }
}

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int exclusiveTimes[] = new int[n];
        int prevProcessEndTime = 0;
        Stack<Log> stack = new Stack<>();
        
        for (String l : logs) {
            Log log = parseLog(l);
            
            if (log.type == LogType.START) {
                if (!stack.isEmpty()) {
                    Log topLog = stack.peek();
                    if (topLog.timestamp >= prevProcessEndTime) {
                        // start - start
                        exclusiveTimes[topLog.processId] += (log.timestamp - topLog.timestamp);
                    } else {
                        // end - start
                        exclusiveTimes[topLog.processId] += (log.timestamp - prevProcessEndTime - 1);
                    }
                }
                stack.push(log);
            } else {
                Log topLog = stack.pop();
                if (topLog.timestamp >= prevProcessEndTime) {
                    // start - end
                    exclusiveTimes[log.processId] += (log.timestamp - topLog.timestamp + 1);
                } else {
                    // end - end
                    exclusiveTimes[log.processId] += (log.timestamp - prevProcessEndTime);
                }
                prevProcessEndTime = log.timestamp;
            }
        }
        
        return exclusiveTimes;
    }
    
    private Log parseLog(String l) {
        String logSplit[] = l.split(":");
        return new Log (
            logSplit[0],
            logSplit[1],
            logSplit[2]
        );
    }
}