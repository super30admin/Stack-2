//TC: O(n)
//SC: O(n)
//approach: Stack, push on start, pop on end

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int prev = 0;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(String log:logs){
            System.out.println(log);
            String[] logArray = log.split(":");
            int id = Integer.parseInt(logArray[0]);
            int time = Integer.parseInt(logArray[2]);
            if(logArray[1].equals("start")){
                if(!stack.isEmpty()){
                    result[stack.peek()]+=time-prev;
                }
                stack.push(id);
                prev = time;
            }else{
                result[id]+=time-prev+1;
                stack.pop();
                prev = time+1;
            }

        }
        return result;
    }
}
