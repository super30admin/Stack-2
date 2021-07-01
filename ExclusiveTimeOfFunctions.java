/*Approach: 
1. These function executions are nothing but a normal function calls. So the function that started in the end will finish first.
2. The obvious choice is to use a stack.
3. We need previous time and current time, to find out the difference
4. Keep adding function ids to a stack if they have been started.
5. Keep manupulating results for the index that is on top of tthe stack (function id is the index)
6. As soon as you hit end, remove the function from the stack.

Space compleixty : O(N/2), essentially N
Time complexity: O(N)
*/

import java.util.*;
class EsxclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] results = new int[n];
        Stack<Integer> mainStack = new Stack<>();
        int funcId=0; int prevTime=0; int currentTime=0;
        
        for(String log : logs)
        {
            String[] splitString = log.split(":");
            funcId = Integer.parseInt(splitString[0]);
            currentTime = Integer.parseInt(splitString[2]);
            
            if(splitString[1].equals("start"))
            {
                if(!mainStack.isEmpty())
                    results[mainStack.peek()] += currentTime-prevTime;
                mainStack.push(funcId);
                prevTime = currentTime;
            }
            else
            {
                results[mainStack.peek()] += currentTime-prevTime+1;
                mainStack.pop();
                prevTime = currentTime+1;
            }
        }
        return results;
    }
}