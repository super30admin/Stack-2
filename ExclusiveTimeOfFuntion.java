/**
 * Uses a stack to simulate function calls; each start pauses the previous function and each end resumes it.
 * Key idea is to track "exclusive time" by subtracting overlapping nested execution using timestamps.
 * Time Complexity: O(n) | Space Complexity: O(n)
 */
public class ExclusiveTimeOfFunction {

    class LogEntry {
        int processId;
        String processName;
        int timeStamp;

        public LogEntry(String log) {
            String[] logArray = log.split(":");
            processId = Integer.valueOf(logArray[0]);
            processName = logArray[1];
            timeStamp = Integer.valueOf(logArray[2]);
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<LogEntry> stk = new Stack<>();

        for (String log : logs) {
            LogEntry currentLog = new LogEntry(log);

            if (currentLog.processName.equals("start")) {
                if (!stk.isEmpty()) {
                    LogEntry previousEntry = stk.peek();
                    // Pause currently running function and add elapsed time until new function starts
                    result[previousEntry.processId] += currentLog.timeStamp - previousEntry.timeStamp;
                }
                // Push new function which now becomes active
                stk.push(currentLog);
            } else {
                LogEntry previousEntry = stk.pop();
                // Add inclusive time (+1) since end timestamp is inclusive
                result[previousEntry.processId] += currentLog.timeStamp - previousEntry.timeStamp + 1;

                if (!stk.isEmpty()) {
                    // Resume parent function from next timestamp after current ends
                    stk.peek().timeStamp = currentLog.timeStamp + 1;
                }
            }
        }
        return result;
    }
}