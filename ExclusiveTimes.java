// 636.
// intuition - seems similar to recursive calls, where we dump parameneters into stack, and process recursive calls
// time - O(length of logs)
// space - O(number of processes)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> process = new Stack<>();
        int time = 0;
        
        //for each log
        for(String log : logs)
        {
            String[] logInfo = log.split(":");
            int id = Integer.parseInt(logInfo[0]); //process id
            String type = logInfo[1]; //start or end
            int currentTime = Integer.parseInt(logInfo[2]); //current time stamp
            
            if(type.equals("start")) //process start
            {
                if(!process.isEmpty())
                {
                    result[process.peek()] += currentTime - time; //update exec time of prev process
                    process.push(id); //push current into stack
                    time = currentTime; //update time 
                }
                else
                {
                    process.push(id); //push current into stack
                    time = currentTime; //update time 
                }
            }
            else //process end
            {
                result[process.pop()] += currentTime - time + 1; //process end, so update exec time of process at top
                time = currentTime + 1; //update time
            }
        }
        return result;
    }
}
