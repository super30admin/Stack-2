import java.util.List;
import java.util.Stack;
class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        // if start pause and record the time to result by adding curr-prev time to result
        // push curr task id to stack if start
        // and update prev with curr
        // else if its end 
        // update result by adding curr+1 - prev to result
        // pop from stack if end

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        int prevTime = 0;
        for(int i = 0; i < logs.size(); i++)
        {
            String[] stringArr = logs.get(i).split(":");
            int taskId = Integer.parseInt(stringArr[0]);
            int currTime = Integer.parseInt(stringArr[2]);
            if(stringArr[1].equals("start"))
            {
                if(!stack.isEmpty())
                {
                    result[stack.peek()] += currTime - prevTime;
                }
                prevTime = currTime;
                stack.push(taskId);
            }
            else
            {
                result[stack.pop()] += currTime+1 - prevTime;
                prevTime = currTime+1;
            }
        }

        return result;
    }
}