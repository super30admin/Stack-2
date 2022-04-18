import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
Time Complexity: O(N), N is the length of logs List
Space Complexity: O(N), using stack
Run on Leetcode: Yes
Any difficulties: no

Approach:
Attempted once discussed in the class
 */
public class ExclusiveTimeOfFunctions {
    public static int[] exclusiveTime(int n, List<String> logs){

        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>();

        for(String log: logs){
            String[] logInfo = log.split(":");
            int logId = Integer.parseInt(logInfo[0]);
            int timeStamp = Integer.parseInt(logInfo[2]);
            String startOrEndString = logInfo[1];

            if(startOrEndString.equals("start")){
                stack.push(new int[]{logId, timeStamp, 0});
            }else{
                int currTime = timeStamp;
                int[] timeIdPair = stack.pop();
                int totalExecutionTime = currTime - timeIdPair[1]+1;
                int activeTime = totalExecutionTime - timeIdPair[2];
                result[timeIdPair[0]] += activeTime;

                if(!stack.isEmpty()){
                    stack.peek()[2] += totalExecutionTime;
                }
            }
        }

        return result;
    }
    public static void main(String[] args){
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");

        System.out.println(Arrays.toString(exclusiveTime(2, logs)));
    }
}
