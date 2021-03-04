/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
**/
class Solution
{
    public int[] exclusiveTime(int n, List<String> logs)
    {
        int results[] = new int[n];
        Arrays.fill(results, 0);
        
        int prevStart = 0;
        Stack<LogTime> stack = new Stack<>();
        
        for(String log: logs)
        {
            LogTime logTime = new LogTime(log);
            
            if(logTime.isStart)
            {
                if(!stack.isEmpty())
                {
                    results[stack.peek().id] += logTime.time - prevStart;
                }
                prevStart = logTime.time;
                stack.push(logTime);
            }
            else
            {
                results[stack.pop().id] += logTime.time - prevStart +1;
                prevStart = logTime.time + 1;
            }
        }
        
        return results;
    }
}
class LogTime
{
    public int id;
    public boolean isStart;
    public int time;
    
    
    public LogTime(String log)
    {
        String logDetails[] = log.split(":");
        
        this.id = Integer.parseInt( logDetails[0]);
        this.isStart = logDetails[1].equals("start");
        this.time = Integer.parseInt( logDetails[2]);
    }
}